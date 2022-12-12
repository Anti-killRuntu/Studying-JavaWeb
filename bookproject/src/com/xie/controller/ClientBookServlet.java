package com.xie.controller;

import com.xie.bean.Book;
import com.xie.bean.Page;
import com.xie.service.BookService;
import com.xie.service.impl.BookServiceImpl;
import com.xie.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xie
 * @create 2022-11-11
 */
public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNumber 和 pageSize
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNumber，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNumber,pageSize);
        //设置url
        page.setUrl("client/bookServlet?action=page");
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    } /**
     * 处理指定价格区间搜索功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNumber 和 pageSize
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2 调用BookService.pageByPrice(pageNumber，pageSize)：Page对象
        Page<Book> page = bookService.pageByPrice(pageNumber,pageSize,min,max);
        //设置url
        StringBuilder url = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null){
            url.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null){
            url.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(url.toString());
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
}
