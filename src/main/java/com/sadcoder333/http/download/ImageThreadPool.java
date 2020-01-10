package com.sadcoder333.http.download;

import java.util.concurrent.*;

/**
 * desc: 简单线程池封装
 * author: sadcoder333
 * date: 2020/1/10
 **/
public class ImageThreadPool {

    private static final int POOL_SIZE = 50;

    private static final int KEEP_ALIVE = 60;

    private static ThreadPoolExecutor threadPoolExecutor;

    private ImageThreadPool() {

    }

    static {
        threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1,
                POOL_SIZE,
                KEEP_ALIVE,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }


    public static void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }


}
