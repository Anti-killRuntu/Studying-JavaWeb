package com.xie.service;

import com.xie.bean.Book;
import com.xie.bean.Page;

import java.util.List;

/**
 * @author xie
 * @create 2022-11-09
 */
public interface BookService {
    //添加图书
    public void addBook(Book book);
    //根据id删除图书
    public void deleteBookById(Integer id);
    //修改图书
    public void updateBook(Book book);
    //根据id查询图书
    public Book queryBookById(Integer id);
    //查询所有图书
    public List<Book> queryBooks();

    Page<Book> page(int pageNumber, int pageSize);

    Page<Book> pageByPrice(int pageNumber, int pageSize, int min, int max);
}
