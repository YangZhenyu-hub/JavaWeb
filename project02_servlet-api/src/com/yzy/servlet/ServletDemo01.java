package com.yzy.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @ClassName ServletDemo01
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-22 20:20
 * @Version
 **/

/*
@WebServlet(urlPatterns = {"/demo01"},
        initParams = {
            @WebInitParam(name="hello",value="world"),
            @WebInitParam(name="uname",value="jim")    
        
        })
        
 */
public class ServletDemo01 extends HttpServlet {

    //重写初始化
    @Override
    public void init() throws ServletException {
        ServletConfig config=getServletConfig();
        config.getInitParameter("hello");

        ServletContext servletContext = getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
    }
}
