package com.yzy.myssm.listeners;

import com.yzy.myssm.ioc.BeanFactory;
import com.yzy.myssm.ioc.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName ContextLoadListener
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 16:29
 * @Version
 **/
//监听上下文启动，在上下文启动的时候去创建IOC容器，然后将其保存到application作用域
//后面中央控制器 Dispatcher再从application作用域中去获取IOC容器
@WebListener
public class ContextLoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //1.获取ServletContext对象
        ServletContext application = servletContextEvent.getServletContext();
        //2.获取上下文的初始化参数 从web.xml中获取applicationContext.xml
        String path = application.getInitParameter("contextConfigLocation");
        //3.根据或的path创建IOC容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);
        //4.将IOC容器保存到作用域中
        application.setAttribute("beanFactory", beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
