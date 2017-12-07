package com.yonyou.dmc.service.task.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**

 * 普通类调用Spring bean对象：

 * 说明：

 * 1、此类需要放到App.java同包或者子包下才能被扫描，否则失效。

 * @author Administrator

 */

@Component("baseSpringUtil")
public class SpringUtil implements ApplicationContextAware{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{

           if(SpringUtil.applicationContext == null){

                  SpringUtil.applicationContext  = applicationContext;

           }
           logger.debug("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtil.applicationContext+"========");

    }

   

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {

           return applicationContext;

    }

   

    //通过name获取 Bean.
    public static Object getBean(String name){

           return getApplicationContext().getBean(name);

    }

   

    //通过class获取Bean.
    public static <T>T getBean(Class<T> clazz){

           return getApplicationContext().getBean(clazz);

    }

   

    //通过name,以及Clazz返回指定的Bean
    public static <T>T getBean(String name,Class<T> clazz){

           return getApplicationContext().getBean(name, clazz);

    }

}
