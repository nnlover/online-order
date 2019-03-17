package com.sust.onlineorder.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页功能对应的实体类
 */
public class Page
{
    private int totalNumber; //总条数
    private int currentPage; //当前页码
    private int totalPage; 	 //总页数

    private int pageNumber = 6; //每页显示条数

    public Page(){}
    public Page(int pageNumber){
        this.pageNumber = pageNumber;
    }

    public void vaildCurrentPageNum(Integer curpage){
        int curpagetmp = 1;
        if (curpage == null) {
            curpagetmp = 1;
        } else {
            curpagetmp = curpage;
        }
        currentPage = curpagetmp;
    }

    public <T> void updatePageInfo(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.setTotalNumber((int)pageInfo.getTotal());
        this.count();
    }


    /*
     * 根据当前对象中属性值计算并设置相关属性值
     */
    private void count()
    {
        //计算总页数
        int totalPageTemp = this.totalNumber /this.pageNumber;
        int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if(totalPageTemp <= 0) {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;

        //设置当前页
        if(this.totalPage < this.currentPage) {
            this.currentPage = this.totalPage;
        }
        if(this.currentPage < 1) {
            this.currentPage =1 ;
        }
    }


    public int getTotalNumber()
    {
        return totalNumber;
    }
    public void setTotalNumber(int totalNumber)
    {
        this.totalNumber = totalNumber;
        this.count();
    }
    public int getCurrentPage()
    {
        return currentPage;
    }
    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }
    public int getTotalPage()
    {
        return totalPage;
    }
    public void setTotalPage(int totalPagr)
    {
        this.totalPage = totalPagr;
    }
    public int getPageNumber()
    {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber)
    {
        this.pageNumber = pageNumber;
    }


}

