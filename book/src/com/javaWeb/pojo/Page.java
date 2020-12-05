package com.javaWeb.pojo;

import java.util.List;

public class Page<B> {

    public static final Integer PAGE_SIZE = 4;

    //1.当前页码
    private Integer pageNo;
    //2.总页码
    private Integer pageTotal;
    //3.当前页显示数量
    private Integer pageSize = PAGE_SIZE;
    //4.总记录数
    private Integer pageTotalCount;
    //5.当前页数据
    private List<B> items;
    //6.设置分页跳转地址
    private String url;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<B> getItems() {
        return items;
    }

    public void setItems(List<B> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<B> items, String url) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
        this.url = url;
    }

    public Page() {
    }
}
