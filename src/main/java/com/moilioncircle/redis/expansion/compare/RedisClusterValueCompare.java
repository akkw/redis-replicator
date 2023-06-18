package com.moilioncircle.redis.expansion.compare;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisClusterValueCompare {

    private final Set<ReadRdbMetadata> clusterMetadata;


    private  Thread worker;


    private ThreadPoolExecutor executor;
    public RedisClusterValueCompare(Set<ReadRdbMetadata> clusterMetadata) {
        this.clusterMetadata = clusterMetadata;
        this.executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }


    public void start() throws FileNotFoundException {
        checkMetadata();
        this.worker = new Thread(()-> {
            for (ReadRdbMetadata metadata : clusterMetadata) {
                submitTask(metadata);
            }
        });
        this.worker.start();
    }

    private void submitTask(ReadRdbMetadata metadata) {
        RedisValueCompare redisValueCompare = new RedisValueCompare(metadata);
        executor.submit(redisValueCompare);
    }


    private void checkMetadata() {
        if (clusterMetadata == null || clusterMetadata.isEmpty()) {
            throw new IllegalArgumentException("cluster metadata is null");
        }

        for (ReadRdbMetadata metadata : clusterMetadata) {
            boolean sourceAddress = metadata.getSourceAddress() == null || metadata.getSourceAddress().trim().length() == 0;
            boolean targetAddress = metadata.getTargetAddress() == null || metadata.getTargetAddress().trim().length() == 0;
            boolean sourcePath = metadata.getSourceRdbPath() == null || metadata.getSourceRdbPath().trim().length() == 0;
            boolean targetPath = metadata.getTargetRdbPath() == null || metadata.getTargetRdbPath().trim().length() == 0;
            if (sourceAddress || targetAddress || sourcePath || targetPath) {
                throw new IllegalArgumentException("cluster metadata check error");
            }
        }
    }
}
