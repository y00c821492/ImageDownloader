package com.sadcoder333.util;

import com.sadcoder333.config.GlobalConfig;

import java.util.logging.Logger;

/**
 * desc: 简单日志类
 * author: sadcoder333
 * date: 2020/1/8
 **/
public class Log {

    private static final Logger logger = Logger.getLogger(GlobalConfig.LOG_TAG);

    private Log() {

    }

    public static void d(String msg) {
        logger.info(msg);
    }
}
