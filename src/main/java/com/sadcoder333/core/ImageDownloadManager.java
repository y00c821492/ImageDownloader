package com.sadcoder333.core;

import com.sadcoder333.config.GlobalConfig;
import com.sadcoder333.config.ImageConfig;
import com.sadcoder333.http.HttpEngine;
import com.sadcoder333.http.download.DownloadPictureRunnable;
import com.sadcoder333.http.download.ImageThreadPool;
import com.sadcoder333.util.HtmlHelper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * desc: 类功能描述
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


    public void download(String htmlUrl) throws IOException {
        String htmlContent = HttpEngine.getHtml(htmlUrl);
        Objects.requireNonNull(htmlContent, "can not read html content for :" + htmlUrl);
        List<String> htmlImages = HtmlHelper.readHtmlImages(htmlContent);
        download(htmlImages);
    }

    public void download(List<String> imageUrls) {
        Objects.requireNonNull(imageUrls, "empty image list");
        imageUrls.forEach(url -> ImageThreadPool.execute(new DownloadPictureRunnable(url)));
    }
}
