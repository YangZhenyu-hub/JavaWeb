package com.yzy.myssm.filter;

import com.yzy.myssm.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName CharacterEncodingFilter
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-23 11:04
 * @Version
 **/
@WebFilter("*.do")
public class CharacterEncodingFilter implements Filter {

    //默认陪配置
    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingStr = filterConfig.getInitParameter("encoding");
        if (StringUtils.isNotEmpty(encodingStr)) {
            encoding = encodingStr;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("CharacterEncodingFilter works");

        ((HttpServletRequest)servletRequest).setCharacterEncoding(encoding);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
