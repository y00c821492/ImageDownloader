package com.sadcoder333;

import com.sadcoder333.config.DefaultImageConfig;
import com.sadcoder333.config.ImageConfig;
import com.sadcoder333.core.DownloadMode;
import com.sadcoder333.core.ImageDownloadManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * 从命令行执行程序时需要传递3个参数：
     * <p>
     * 第一个参数表示下载模式，如果需要从html网页自动抓取图片下载这个参数为0， 如果需要直接通过图片链接下载这个参数为1
     * 第二个参数表示图片下载目录，支持多级目录，如果目录不存在会自动创建子目录
     * 当第一个参数为0时，第三个参数为网页地址，比如参数设置为http://abc/12345.html
     * 当第一个参数为1时，第三个参数为多张图片地址列表，用英文逗号分隔多个参数，如http//abc/1.jpg,http://abc2.jpg
     * <p>
     * <p>
     * <p>
     * 抓取某个html网页的命令行如下：
     * java -jar ImageDownloader-1.0.jar 0 D:/download http://abc/12345.html
     * <p>
     * 下载多张图片的命令行如下：
     * java -jar ImageDownloader-1.0.jar 1 D:/download http//abc/1.jpg,http://abc2.jpg,http://abc2.jpg
     *
     * @param args 命令行参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException("please pass three arguments! ");
        }

        int downloadMode;
        try {
            downloadMode = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The first argument should be an integer number");
        }
        if (downloadMode == DownloadMode.HTML.ordinal()) {
            String downloadDir = args[1];
            String htmlUrl = args[2];
            ImageConfig imageConfig = new DefaultImageConfig.Builder()
                    .downloadDir(downloadDir)
                    .create();
            ImageDownloadManager
                    .getInstance(imageConfig)
                    .downloadImages(htmlUrl);
        } else if (downloadMode == DownloadMode.IMAGES.ordinal()) {
            String downloadDir = args[1];
            String arg2 = args[2];
            List<String> imageUrls = Arrays
                    .stream(arg2.split(","))
                    .filter(url -> {
                        String lowerUrl = url.toLowerCase();
                        return lowerUrl.startsWith("http") || lowerUrl.startsWith("https");
                    })
                    .collect(Collectors.toList());
            if (imageUrls.isEmpty()) {
                throw new IllegalArgumentException("Did you pass correct image urls?");
            }

            ImageConfig imageConfig = new DefaultImageConfig.Builder()
                    .downloadDir(downloadDir)
                    .create();
            ImageDownloadManager
                    .getInstance(imageConfig)
                    .downloadImagesByUrl(imageUrls);
        } else {
            throw new IllegalArgumentException("The first argument should be 0 or 1");
        }
    }
}
