package com.adapter.mango.tv.sohu.jafka;

import java.io.IOException;

import com.sohu.jafka.api.FetchRequest;
import com.sohu.jafka.consumer.SimpleConsumer;
import com.sohu.jafka.message.MessageAndOffset;
import com.sohu.jafka.utils.Utils;

public class JafkaCousumer {

    public static void main(String[] args){
        SimpleConsumer consumer = new SimpleConsumer("10.22.10.139", 9092);
        //
        long offset = 950335986;
        while (true) {
            FetchRequest request = new FetchRequest("demo", 0, offset);
            try {
                for (MessageAndOffset msg : consumer.fetch(request)) {
                    System.out.println(offset + ":" + Utils.toString(msg.message.payload(), "UTF-8"));
                    offset = msg.offset;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
