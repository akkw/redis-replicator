package com.moilioncircle.redis.expansion.compare;

import com.moilioncircle.redis.replicator.RedisRdbReplicator;
import com.moilioncircle.redis.replicator.RedisReplicator;
import com.moilioncircle.redis.replicator.Replicator;

import java.io.IOException;
import java.net.URISyntaxException;

public class RedisValueCompare extends Thread {
    private ReadRdbMetadata readRdbMetadata;


    private Replicator sourceReplicator;

    private Replicator targetReplicator;


    public RedisValueCompare(ReadRdbMetadata metadata) {
        this.readRdbMetadata =  metadata;
    }


    @Override
    public void run() {
        String sourceAddress = readRdbMetadata.getSourceAddress();
        String targetAddress = readRdbMetadata.getTargetAddress();

        try {
            this.sourceReplicator = new RedisReplicator(sourceAddress);
            this.targetReplicator = new RedisReplicator(targetAddress);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
