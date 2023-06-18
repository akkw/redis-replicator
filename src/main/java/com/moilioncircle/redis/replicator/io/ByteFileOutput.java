package com.moilioncircle.redis.replicator.io;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ByteFileOutput {
    private RandomAccessFile file;

    private MappedByteBuffer mmapBuf;

    private final String filepath;

    private boolean isFileMap;

    public ByteFileOutput(String filepath) throws FileNotFoundException {
       this.filepath = filepath;
        this.file = new RandomAccessFile(new File(filepath), "rw");
    }


    private void setWriteWay(long size) throws IOException {
        if (size <= Integer.MAX_VALUE) {
            this.isFileMap = true;
            this.mmapBuf = file.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, size);
        }
    }

    private void write(byte[] payload) throws IOException {
        if (isFileMap) {
            this.mmapBuf.put(payload);
            this.mmapBuf.force();
        } else {
            this.file.write(payload);
        }

    }

}
