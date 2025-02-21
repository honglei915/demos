package com.leiui.niodemo.zk;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Created by cuilei05 on 2025/01/27/17:05.
 */
public class ZkLock {
    private ZooKeeper zooKeeper;

    {
        try {
            zooKeeper = new ZooKeeper("",1,false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lock() throws InterruptedException, KeeperException {
        Stat state = zooKeeper.exists("1", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeDeleted)
                    ;
            }
        });
    }
}
