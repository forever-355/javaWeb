package com.javaWeb.service.impl;

import com.javaWeb.dao.BookDao;
import com.javaWeb.dao.impl.BookDaoImpl;
import com.javaWeb.pojo.Book;
import com.javaWeb.pojo.Page;
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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        //分页的边界控制
        if(pageNo <1 ){
            pageNo = 1;
        } else if(pageNo > pageTotal){
            pageNo = pageTotal;
        }

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        //分页的边界控制
        if(pageNo <1 ){
            pageNo = 1;
        } else if(pageNo > pageTotal){
            pageNo = pageTotal;
        }

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
