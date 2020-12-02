package com.javaWeb.dao;

import com.javaWeb.pojo.Book;

import java.util.List;

public interface BookDao {

    //添加图书
    public int addBook(Book book);

    //删除图书
    public int deleteBook(Integer id);

    //修改图书
    public int updateBook(Book book);

    //查找图书----1
    public Book queryBookById(Integer id);
    //查找图书----2
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
}
