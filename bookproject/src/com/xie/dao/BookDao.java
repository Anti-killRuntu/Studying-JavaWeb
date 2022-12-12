package com.xie.dao;

import com.xie.bean.Book;

import java.util.List;

/**
 * @author xie
 * @create 2022-11-09
 */
public interface BookDao {
    //添加图书
    public int addBook(Book book);
    //根据id删除图书
    public int deleteBookById(Integer id);
    //修改图书
    public int updateBook(Book book);
    //根据id查询图书
    public Book queryBookById(Integer id);
    //查询所有图书
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);


    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
