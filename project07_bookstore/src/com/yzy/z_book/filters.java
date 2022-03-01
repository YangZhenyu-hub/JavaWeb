package com.yzy.z_book;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 登录拦截器
 * @ClassName filters
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 20:25
 * @Version
 **/

@WebFilter(urlPatterns = {"*.do","*.html"},
        initParams = {
        @WebInitParam(name = "bai", value = "/bookstore/page.do?operate=page&page=user/login,/bookstore/user.do?null,/bookstore/page.do?operate=page&page=user/regist")
        })
public class filters implements Filter {

    List<String> baiList=null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String bai = filterConfig.getInitParameter("bai");
        String[] baiArray = bai.split(",");
        baiList= Arrays.asList(baiArray);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest ;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String str=uri+"?"+queryString;

        if (baiList.contains(str)) {
            filterChain.doFilter(request,response);
        }else {
            HttpSession session = request.getSession();
            Object currUserObj = session.getAttribute("currUser");
            if (currUserObj == null) {
                response.sendRedirect("page.do?operate=page&page=user/login");
            } else {

                filterChain.doFilter(request,response);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
