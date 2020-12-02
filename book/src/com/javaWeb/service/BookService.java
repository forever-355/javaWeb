package com.javaWeb.service;

import com.javaWeb.pojo.Book;
import com.javaWeb.pojo.Page;

import java.util.List;

public interface BookService {

    //添加图书
    public void addBook(Book book);

    //删除图书
    public void deleteBook(Integer id);

    //修改图书
    public void updateBook(Book book);

    //查找图书----1
    public Book queryBookById(Integer id);

    //查找图书----2
    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);
}
