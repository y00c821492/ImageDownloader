package com.sadcoder333.config;


/**
 * desc: 默认配置参数
 * author: sadcoder333
 * date: 2020/1/10
 **/
public class DefaultImageConfig implements ImageConfig {
    private String downloadDir;
    private int timeout;

    DefaultImageConfig(String downloadDir, int timeout) {
        this.downloadDir = downloadDir;
        if (timeout <= 0) {
            timeout = DEFAULT_TIMEOUT;
        }
        this.timeout = timeout;

    }

    @Override
    public String getDownloadDir() {
        return downloadDir;
    }

    @Override
    public int timeout() {
        return timeout;
    }


    public static class Builder {
        String downloadDir;
        int timeout;

        public Builder downloadDir(String downloadDir) {
            this.downloadDir = downloadDir;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public DefaultImageConfig create() {
            return new DefaultImageConfig(downloadDir, timeout);
        }
    }
}
