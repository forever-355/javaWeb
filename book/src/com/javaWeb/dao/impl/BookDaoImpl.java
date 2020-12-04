package com.javaWeb.dao.impl;

import com.javaWeb.dao.BookDao;
import com.javaWeb.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    //添加图书
    public int addBook(Book book) {
        String sql = "insert into table_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    //删除图书
    public int deleteBook(Integer id) {
        String sql = "delete from table_book where id = ?";
        return update(sql,id);
    }

    @Override
    //修改图书
    public int updateBook(Book book) {
        String sql = "update table_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    //查找图书----1
    public Book queryBookById(Integer id) {
        String sql = "select * from table_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    //查找图书----2
    public List<Book> queryBooks() {
        String sql = "select * from table_book";
        return queryForList(Book.class,sql);
    }

    @Override
    //查找符合价格区间的总数
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from table_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    //查找符合价格区间的图书
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from table_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    //查找min---max之间的条数
    public Integer queryForPageTotalCountByPrice(int min,int max) {
        String sql = "select count(*) from table_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    //查找符合价格区间，那个页面
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select * from table_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }


}
