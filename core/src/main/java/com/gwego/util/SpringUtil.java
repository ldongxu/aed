package com.gwego.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author liudongxu06
 * @date 2017/10/20
 */
public class SpringUtil implements ApplicationContextAware{
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext==null){
            SpringUtil.applicationContext=applicationContext;
        }
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static <T>T getBean(Class<T> clzz){
        return applicationContext.getBean(clzz);
    }

    public static <T> T getBean(String name,Class<T> clazz){
        return applicationContext.getBean(name,clazz);
    }
}
