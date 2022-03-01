package com.yzy.myssm.filter;

import com.yzy.myssm.trans.TransactionManger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName OpenSessionInViewFilter
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 16:06
 * @Version
 **/

@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            TransactionManger.beginTrans();
            filterChain.doFilter(servletRequest,servletResponse);
            TransactionManger.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                TransactionManger.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void destroy() {

    }
}
