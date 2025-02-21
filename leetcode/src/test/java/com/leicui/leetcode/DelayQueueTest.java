package com.leicui.leetcode;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by cuilei05 on 2024/12/30/11:08.
 */
public class DelayQueueTest {
    public void test(){
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.put(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        });
    }
}
