package com.adapter.mango.tv.sohu.jafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.sohu.jafka.consumer.Consumer;
import com.sohu.jafka.consumer.ConsumerConfig;
import com.sohu.jafka.consumer.ConsumerConnector;
import com.sohu.jafka.consumer.MessageStream;
import com.sohu.jafka.producer.serializer.StringDecoder;
import com.sohu.jafka.producer.serializer.StringEncoder;
import com.sohu.kafkademon.KafkaProperties;

public class JafkaConsumerGetOffset {
    public static void main(String[] args) {
        // SimpleConsumer consumer = new SimpleConsumer("10.22.10.139", 9092);
        Properties props = new Properties();

        // 指明zookeeper地址
        // props.setProperty("brokerid", "1");
        // props.setProperty("port", "9092");
        // props.setProperty("hostname", "10.22.10.139");
        props.put("zk.connect", KafkaProperties.zkConnect);
        props.put("serializer.class", StringEncoder.class.getName());
        props.put("zk.connectiontimeout.ms", KafkaProperties.connectionTimeOut + "");
        // 指明consumer group的名字
        props.setProperty("groupid", "test_group");
        ConsumerConfig config = new ConsumerConfig(props);
        // 创建了ZookeeperConsumerConnector，连接zookeeper，获取当前topic的数据信息
        ConsumerConnector connector = Consumer.create(config);
        // 指明每一个topic的消费线程数
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(KafkaProperties.topic, 10);
        // topicCountMap.put("hehe3", 1);

        // 创建消费消息流，key为topic，value为MessageStream的list，大小为上面map中指定的大小
        Map<String, List<MessageStream<String>>> streams = connector.createMessageStreams(topicCountMap,
                new StringDecoder());

        List<MessageStream<String>> messageStreamList = streams.get(KafkaProperties.topic);
        // messageStreamList.addAll(streams.get("hehe3"));
        final AtomicInteger count = new AtomicInteger(0);
        final AtomicInteger streamCount = new AtomicInteger(0);

        // 创建线程池，该线程池数目必须不小于上面所有的消费线程数
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 提交消费任务，开始消费消息
        for (final MessageStream<String> stream : messageStreamList) {
            executor.execute(new Runnable() {
                public void run() {
                    int threadNum = streamCount.incrementAndGet();
                    // 从stream中获取消息，此处为阻塞式消费，即当没有新消息到来时，阻塞直到新消息到来或者线程结束
                    // 通过BlockingQueue实现，后续内容会详细讲解
                    for (String msg : stream) {
                        System.out.println("stream#" + threadNum + ":msg#" + count.incrementAndGet() + "=>" + msg);
                    }
                }
            });
        }

        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
