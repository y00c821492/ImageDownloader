package com.sadcoder333.config;

import java.util.Objects;

/**
 * desc: 默认配置参数
 * author: sadcoder333
 * date: 2020/1/10
 **/
public class DefaultImageConfig implements ImageConfig {
    private String baseDir;
    private String folder;
    private int timeout;

    DefaultImageConfig(String baseDir, String folder, int timeout) {
        this.baseDir = baseDir;
        this.folder = folder;
        if (timeout <= 0) {
            throw new IllegalArgumentException("you must set a value for timeout");
        }
        this.timeout = timeout;

    }

    @Override
    public String getBaseDir() {
        return baseDir;
    }

    @Override
    public String getFolderName() {
        return folder;
    }

    @Override
    public int timeout() {
        return timeout;
    }


    public static class Builder {
        String baseDir;
        String folder;
        int timeout;

        public Builder baseDir(String baseDir) {
            this.baseDir = baseDir;
            return this;
        }

        public Builder folder(String folder) {
            this.folder = folder;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public DefaultImageConfig create() {
            return new DefaultImageConfig(baseDir, folder, timeout);
        }
    }
}
