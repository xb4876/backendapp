package com.renwu.backendapp.core.utils;

/**
 * <p>创建时间 : 2018-07-03 10:22 </p>
 * <p>类描述 :  日志工具类  </p>
 *
 * @author ChenZhang(chen - zhang @ foxmail.com)
 * @version 1.0.0
 */
public class LoggerUtil {
    /**
     * 是否开启Debug
     */
    public static boolean isDebug =  org.slf4j.LoggerFactory.getLogger(LoggerUtil.class).isDebugEnabled();

    /**
     * Debug 输出
     * @param clazz  	目标.Class
     * @param message	输出信息
     */
    public static void debug(Class<? extends Object> clazz ,String message){
        if(!isDebug) return ;
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
        logger.debug(message);
    }

    /**
     * info 输出
     * @param clazz  	目标.Class
     * @param message	输出信息
     */
    public static void info(Class<? extends Object> clazz ,String message){
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
        logger.info(message);
    }

    /**
     * warn 输出
     * @param clazz  	目标.Class
     * @param message	输出信息
     */
    public static void warn(Class<? extends Object> clazz ,String message){
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
        logger.warn(message);
    }

    /**
     * error 输出
     * @param clazz  	目标.Class
     * @param message	输出信息
     */
    public static void error(Class<? extends Object> clazz ,String message){
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
        logger.error(message);
    }

    /**
     * error 输出
     * @param clazz  	目标.Class
     * @param message	输出信息
     * @param e 异常对象
     */
    public static void error(Class<? extends Object> clazz ,String message, Exception e){
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
        logger.error(message, e);
    }

}
