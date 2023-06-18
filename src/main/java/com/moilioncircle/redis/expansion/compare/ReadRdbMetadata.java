package com.moilioncircle.redis.expansion.compare;

public class ReadRdbMetadata {

    private  String sourceAddress;

    private  String targetAddress;

    private  String sourceRdbPath;


    private  String targetRdbPath;


    public ReadRdbMetadata() {
    }

    public ReadRdbMetadata(String sourceAddress, String targetAddress, String sourceRdbPath, String targetRdbPath) {
        this.sourceAddress = sourceAddress;
        this.targetAddress = targetAddress;
        this.sourceRdbPath = sourceRdbPath;
        this.targetRdbPath = targetRdbPath;
    }


    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public String getSourceRdbPath() {
        return sourceRdbPath;
    }

    public void setSourceRdbPath(String sourceRdbPath) {
        this.sourceRdbPath = sourceRdbPath;
    }

    public String getTargetRdbPath() {
        return targetRdbPath;
    }

    public void setTargetRdbPath(String targetRdbPath) {
        this.targetRdbPath = targetRdbPath;
    }
}
