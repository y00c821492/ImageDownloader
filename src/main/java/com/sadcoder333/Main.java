package com.sadcoder333;

import com.sadcoder333.config.DefaultImageConfig;
import com.sadcoder333.config.ImageConfig;
import com.sadcoder333.core.ImageDownloadManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ImageConfig imageConfig = new DefaultImageConfig.Builder()
                .baseDir("D:/test")
                .folder("2020")
                .timeout(60)
                .create();
        ImageDownloadManager
                .getInstance(imageConfig)
                .download("http://xxxx.html");


    }
}
