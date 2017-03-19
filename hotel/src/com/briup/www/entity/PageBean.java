package com.briup.www.entity;

import java.util.List;

/**
 *分页的实体类
 * @author wangfali
 *@version 1.0
 * @param <T>
 *@date 2016年12月22日
 */
public class PageBean<T> {
	private  long currentPage=1;//当前页
	private  long pageCount=4;//显示的内容行
	private  long allPageColum;//总的内容行
	private  long allPageCount;//总的页数
	private List<T>pageList;//查询分页返回的数据
	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getAllPageColum() {
		return allPageColum;
	}
	public void setAllPageColum(long allPageColum) {
		this.allPageColum = allPageColum;
	}
	public long getAllPageCount() {
		//判断页面不是整数
		if(allPageColum%pageCount==0){
			return allPageColum/pageCount;
		}
		return allPageColum/pageCount+1;
	}
	public void setAllPageCount(long allPageCount) {
		this.allPageCount = allPageCount;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public PageBean(long currentPage, long pageCount, long allPageColum,
			long allPageCount, List<T> pageList) {
		super();
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.allPageColum = allPageColum;
		this.allPageCount = allPageCount;
		this.pageList = pageList;
	}
	public PageBean() {
		super();
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageCount="
				+ pageCount + ", allPageColum=" + allPageColum
				+ ", allPageCount=" + allPageCount + ", pageList=" + pageList
				+ "]";
	}
	
}
