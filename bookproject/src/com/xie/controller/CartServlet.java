package com.xie.controller;

import com.xie.bean.Book;
import com.xie.bean.Cart;
import com.xie.bean.CartItem;
import com.xie.service.BookService;
import com.xie.service.impl.BookServiceImpl;
import com.xie.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xie
 * @create 2022-11-14
 */
public class CartServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收商品编号和修改数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.updateItem(id,count);
            //重定向跳回原界面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.clear();
            //重定向跳回原界面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    /**
     * 删除购物车商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //获取商品对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.deleteItem(id);
            //重定向跳回原界面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      接收商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转换为商品项
        CartItem cartitem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //把商品项放入session域中
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartitem);
        //重定向跳回原界面
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
