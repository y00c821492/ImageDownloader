package com.sadcoder333.http;

import com.sadcoder333.config.GlobalConfig;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * desc: http工具类
 * author: sadcoder333
 * date: 2020/1/8
 **/
public class HttpEngine {

    private HttpEngine() {

    }

    private static final int DEFAULT_TIME_OUT = 60;

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .build();


    /**
     * 下载图片
     *
     * @param url      图片链接地址
     * @param callback 请求回调
     */
    public static void downloadImage(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }


    /**
     * 读取一个url的html文本内容
     *
     * @param url 网页地址
     * @return 网页的html代码
     * @throws IOException IO异常
     */
    public static String getHtml(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                return responseBody.string();
            }
        }
        return null;
    }


}
