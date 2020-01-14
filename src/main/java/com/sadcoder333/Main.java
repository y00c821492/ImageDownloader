package com.sadcoder333;

import com.sadcoder333.config.DefaultImageConfig;
import com.sadcoder333.config.ImageConfig;
import com.sadcoder333.core.DownloadConstants;
import com.sadcoder333.core.ImageDownloadManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * 从命令行执行程序时需要传递3个参数：
     * <p>
     * 第一个参数表示图片下载目录，支持多级目录，如果目录不存在会自动创建子目录
     * 第二个参数为htmls.txt时，必须存在这个文件，文件内容每行为html网页地址
     * 第二个参数为images.txt时，必须存在这个文件，文件内容每行为每张图片的链接地址
     * <p>
     * <p>
     * <p>
     * 抓取html网页中的图片的命令行如下：
     * java -jar ImageDownloader-1.0.jar D:/download htmls.txt
     * <p>
     * 下载多张图片的命令行如下：
     * java -jar ImageDownloader-1.0.jar D:/download images.txt
     *
     * @param args 命令行参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("please pass one argument at least! ");
        }

        String downloadDir = args[0];
        String filename = args[1].trim();
        if (DownloadConstants.FILE_HTMLS.equals(filename)) {
            File htmlFile = new File(DownloadConstants.FILE_HTMLS);
            List<String> htmlUrls;
            try {
                htmlUrls = FileUtils.readLines(htmlFile, "UTF-8");
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            if (htmlUrls.isEmpty()) {
                throw new IllegalArgumentException("can not find htmls from " + DownloadConstants.FILE_HTMLS);
            }

            ImageConfig imageConfig = new DefaultImageConfig.Builder()
                    .downloadDir(downloadDir)
                    .create();

            for (String htmlUrl : htmlUrls) {
                ImageDownloadManager
                        .getInstance(imageConfig)
                        .downloadImages(htmlUrl);
            }
        } else if (DownloadConstants.FILE_IMAGES.equals(filename)) {
            File imagesFile = new File(DownloadConstants.FILE_IMAGES);
            List<String> imageUrls = FileUtils.readLines(imagesFile, "UTF-8")
                    .stream()
                    .filter(imageUrl -> imageUrl.toLowerCase().startsWith("http"))
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
            throw new IllegalArgumentException("can not find " + DownloadConstants.FILE_HTMLS + " or " + DownloadConstants.FILE_IMAGES);
        }
    }
}
