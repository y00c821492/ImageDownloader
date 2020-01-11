package com.sadcoder333.core;

import com.sadcoder333.config.GlobalConfig;
import com.sadcoder333.config.ImageConfig;
import com.sadcoder333.http.HttpEngine;
import com.sadcoder333.http.download.DownloadPictureRunnable;
import com.sadcoder333.http.download.ImageThreadPool;
import com.sadcoder333.util.HtmlHelper;
import com.sadcoder333.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * desc: 下载管理器
 * author: sadcoder333
 * date: 2020/1/10
 **/
public class ImageDownloadManager {

    private static ImageDownloadManager imageDownloadManager;

    private ImageDownloadManager(ImageConfig imageConfig) {
        GlobalConfig.setImageConfig(imageConfig);
    }


    public static ImageDownloadManager getInstance(ImageConfig imageConfig) {
        if (imageDownloadManager == null) {
            synchronized (ImageDownloadManager.class) {
                if (imageDownloadManager == null) {
                    imageDownloadManager = new ImageDownloadManager(imageConfig);
                }
            }
        }
        return imageDownloadManager;
    }


    public void downloadImages(String htmlUrl) throws IOException {
        String htmlContent = HttpEngine.getHtml(htmlUrl);
        Objects.requireNonNull(htmlContent, "can not read html content for :" + htmlUrl);
        List<String> htmlImages = HtmlHelper.readHtmlImages(htmlContent);
        downloadImagesByUrl(htmlImages);
    }

    public void downloadImagesByUrl(List<String> imageUrls) {
        if (imageUrls == null || imageUrls.isEmpty()) {
            Log.d("empty image list");
            return;
        }
        imageUrls.forEach(url -> ImageThreadPool.execute(new DownloadPictureRunnable(url)));
    }
}
