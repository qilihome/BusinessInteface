package com.weichat.boss.core.util;




public class PageBO
{
    private static final int CONFIG_PAGESIZE = 10;

    private int totalNum = 0;

    private int fromPageNum = 0;// 数据库物理记录起始点

    private int pageSize = 0;

    private int curPage = 1;

    public PageBO()
    {
        if (pageSize <= 0)
        {
            pageSize = CONFIG_PAGESIZE;
        }
    }

    public PageBO(int defaultPageSize)
    {
        if (pageSize <= 0)
        {
            pageSize = defaultPageSize;
        }
    }

    public int getTotalNum()
    {
        return totalNum;
    }

    public void setTotalNum(int totalNum)
    {
        this.totalNum = totalNum;
        int lastPage = getLastPage();
        if (lastPage < curPage)
            curPage = lastPage;
    }

    public int getFromPageNum()
    {
        return fromPageNum;
    }

    public void setFromPageNum(int fromPageNum)
    {
        this.fromPageNum = fromPageNum;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getCurPage()
    {
        return curPage;
    }

    public int getLastPage()
    {
        if(totalNum <= 0)
            return 1;
        return (totalNum % pageSize == 0) ? totalNum / pageSize : (totalNum / pageSize + 1);
    }

    public void setCurPage(int curPage)
    {
        this.curPage = curPage;
    }

}
