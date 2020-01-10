package com.sadcoder333.config;

/**
 * desc: 全局配置
 * author: sadcoder333
 * date: 2020/1/10
 **/
public class GlobalConfig {

    public static final String LOG_TAG = "ImageDownloadManager";

    private static ImageConfig imageConfig;

    public static void setImageConfig(ImageConfig imageConfig) {
        GlobalConfig.imageConfig = imageConfig;
    }

    public static ImageConfig getImageConfig() {
        return imageConfig;
    }
}
