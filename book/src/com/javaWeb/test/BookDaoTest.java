package com.javaWeb.test;

import com.javaWeb.dao.BookDao;
import com.javaWeb.dao.impl.BookDaoImpl;
import com.javaWeb.pojo.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    //添加图书
    @Test
    public void addBook() {
        //name,price,author,sales,stock,img_path
        bookDao.addBook(new Book(null,"测试图书",20,"fll",20,0,null));
    }

    //删除图书
    @Test
    public void deleteBook() {
        bookDao.deleteBook(21);
        System.out.println("删除成功！");
    }

    //修改图书
    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"测试图书1",201,"f1ll",201,0,null));
    }

    //查找图书----1
    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(3));
        System.out.println(bookDao.queryBookById(2));
    }

    //查找图书----2
    @Test
    public void queryBooks() {
        for(Book queryBook:bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(1,30));
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(0,4));
    }

    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(bookDao.queryForPageItemsByPrice(0,4,10,50));
    }


}