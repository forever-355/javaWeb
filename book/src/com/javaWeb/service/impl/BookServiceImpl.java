package com.javaWeb.service.impl;

import com.javaWeb.dao.BookDao;
import com.javaWeb.dao.impl.BookDaoImpl;
import com.javaWeb.pojo.Book;
import com.javaWeb.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();
    @Override
    //添加图书
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
   //删除图书
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    //修改图书
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    //查找图书----1
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    //查找图书----2
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
