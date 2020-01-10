package com.sadcoder333.config;

/**
 * desc: 类功能描述
 * author: sadcoder333
 * date: 2020/1/10
 **/
public interface ImageConfig {

    String getBaseDir();

    default boolean sortImageByOrder() {
        return false;
    }

    String getFolderName();


    int timeout();

}
