package com.javaWeb.test;

import com.javaWeb.pojo.Book;
import com.javaWeb.service.BookService;
import com.javaWeb.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    //添加图书
    @Test
    public void addBook(){
        bookService.addBook(new Book(null,"测试",51,"谢希仁",4,16,null));
    }

    //删除图书
    @Test
    public void deleteBook(){
        bookService.deleteBook(22);
    }

    //修改图书
    @Test
    public void updateBook(){
        bookService.updateBook(new Book(22,"测试1",511,"谢希仁1",41,116,null));
    }

    //查找图书----1
    @Test
    public void queryBookById(){
        System.out.println(bookService.queryBookById(2));
    }

    //查找图书----2
    @Test
    public void queryBooks(){
        for(Book book:bookService.queryBooks()){
            System.out.println(book);
        }

    }

    @Test
    public void page(){
        System.out.println(bookService.page(1,4));
    }

}