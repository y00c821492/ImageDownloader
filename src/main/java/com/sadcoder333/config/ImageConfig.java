package com.sadcoder333.config;

/**
 * desc: 类功能描述
 * author: sadcoder333
 * date: 2020/1/10
 **/
public interface ImageConfig {

    int DEFAULT_TIMEOUT = 60;

    String getDownloadDir();

    default boolean sortImageByOrder() {
        return false;
    }

    int timeout();

}
