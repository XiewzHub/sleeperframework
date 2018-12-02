package com.chenxuanplus.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

/*
 * @Author chenxuan
 * @Description
 * @Date 3:29 PM 2018/12/2
 * @Param
 * @return
 **/
public class BeanUtil {
    private static ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();

    /**
     * 根据bean名称获取
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return ctx.getBean(name);
    }

    public static void setApplicationContext(ApplicationContext ctx){
        BeanUtil.ctx = ctx;
    }

    public static <T> T getBean(Class<T> clazz){
        return (T)ctx.getBean(clazz);
    }
}

