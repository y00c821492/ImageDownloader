package com.sadcoder333.http.download;


import com.sadcoder333.http.HttpEngine;
import com.sadcoder333.http.callback.ImageCallback;
import com.sadcoder333.util.Log;

/**
 * desc: 类功能描述
 * author: sadcoder333
 * date: 2020/1/8
 **/
public class DownloadPictureRunnable implements Runnable {

    private String imageUrl;

    public DownloadPictureRunnable(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void run() {
        Log.d("start to downloadImagesByUrl image url: " + imageUrl);
        try {
            HttpEngine.downloadImage(imageUrl, new ImageCallback(imageUrl));
        } catch (Exception e) {
            Log.d("fail to downloadImagesByUrl image url: " + imageUrl);
        }
    }
}
