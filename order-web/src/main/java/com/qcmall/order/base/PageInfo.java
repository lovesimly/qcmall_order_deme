package com.qcmall.order.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 分页
 * */
public class PageInfo {

    private Integer              totalItem;//总条数
    private String              pageSize;
    private String              currentPage;
    private int                  startRow;
    private int                  endRow;
    private int                  totalPage;//总页数

    public int getStartRow() {
        return (Integer.parseInt(this.getCurrentPage()) - 1) * this.getPageSize() + 1;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return Integer.parseInt(this.getCurrentPage()) * this.getPageSize();
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
        totalPage = getTotalPage(Integer.parseInt(pageSize),totalItem);
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return 10;
        }
        return Integer.parseInt(pageSize);
    }

    public void setPageSize(String pSize) {
        if (pSize == null || "".equals(pSize)) {
            this.pageSize = "10";
        }
        this.pageSize = pSize;
    }
    
    public String getCurrentPage() {
        if (currentPage == null) {
            return "1";
        }
        return currentPage;
    }

    public void setCurrentPage(String cPage) {
        if ((cPage == null) || "".equals(cPage)) {
            this.currentPage = "1";
        } else {
            this.currentPage = cPage;
        }
    }
    

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage(int pgSize,int total) {
        int result = total / pgSize;
        if ((total % pgSize) != 0) {
            result++;
        }
        return result;
    }
    
    public Map<String,Object> toQueryMap(){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("startRow", getStartRow());
        params.put("endRow", getEndRow());
        params.put("offset", getStartRow()-1);
        params.put("pageSize", getPageSize());
        return params;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
}
