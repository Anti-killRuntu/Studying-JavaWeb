package com.xie.filter;

import com.xie.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xie
 * @create 2022-11-15
 */
public class TransactionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        } catch (IOException e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();//回滚事务
        }
    }
}
