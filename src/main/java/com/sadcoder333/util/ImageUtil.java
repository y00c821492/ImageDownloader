package com.sadcoder333.util;

import com.sadcoder333.config.GlobalConfig;

import java.io.File;

/**
 * desc: 生成图片文件路径的工具类
 * author: sadcoder333
 * date: 2020/1/8
 **/
public class ImageUtil {

    /**
     * 从图片路径名中读取文件名
     *
     * @param url 图片全路径名
     * @return 图片名
     */
    private static String getImageName(String url) {
        int index = url.lastIndexOf("/" + 1);
        return url.substring(index);
    }


    /**
     * 根据配置参数生成图片路径
     *
     * @param url 图片链接地址
     * @return 图片的文件路径
     */
    public static File getImageFile(String url) {
        String imageName = getImageName(url);
        String downloadDir = GlobalConfig.getImageConfig().getDownloadDir();

        File folder = new File(downloadDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return new File(folder, imageName);
    }
}
