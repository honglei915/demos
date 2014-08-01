package com.adapter.mango.tv.sohu.jafka;

import java.util.Properties;

import com.sohu.jafka.producer.Producer;
import com.sohu.jafka.producer.ProducerConfig;
import com.sohu.jafka.producer.StringProducerData;
import com.sohu.jafka.producer.serializer.StringEncoder;
import com.sohu.kafkademon.KafkaProperties;

public class JafkaProduce {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("zk.connect", KafkaProperties.zkConnect);
        props.put("serializer.class", StringEncoder.class.getName());

        // props.put("broker.list", "0:10.22.10.139:9092");
        props.put("zk.connectiontimeout.ms", KafkaProperties.connectionTimeOut+"");
        //
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);
        //
        StringProducerData data = new StringProducerData(KafkaProperties.topic);
        for (int i = 0; i < 10000; i++) {
            data.add("Hello world #" + i);
        }
        //
        try {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                producer.send(data);
            }
            long cost = System.currentTimeMillis() - start;
            System.out.println("send 100000 message cost: " + cost + " ms");
        } finally {
            producer.close();
        }
    }
}
