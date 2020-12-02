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

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }

    public Page() {
    }
}
