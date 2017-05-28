package com.briup.www.entity;
/**
 * 
* @ClassName: Page
* @Description: 分页类型
* @author wangfali
* @date 2017年5月28日 上午10:06:52
*
 */

import java.util.ArrayList;
import java.util.List;

public class Page {
	private Integer currPageNo;//当前页面
	private Integer perPageSize=2;//显示页面大小
	private Integer allRecordNo;//总记录数
	private Integer allPageNo;//总页数
	private List<Article>articles=new ArrayList<Article>();//集合
	public Integer getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}
	public Integer getPerPageSize() {
		return perPageSize;
	}
	public void setPerPageSize(Integer perPageSize) {
		this.perPageSize = perPageSize;
	}
	public Integer getAllRecordNo() {
		return allRecordNo;
	}
	public void setAllRecordNo(Integer allRecordNo) {
		this.allRecordNo = allRecordNo;
	}
	public Integer getAllPageNo() {
		return allPageNo;
	}
	public void setAllPageNo(Integer allPageNo) {
		this.allPageNo = allPageNo;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Page(Integer currPageNo, Integer perPageSize, Integer allRecordNo, Integer allPageNo,
			List<Article> articles) {
		super();
		this.currPageNo = currPageNo;
		this.perPageSize = perPageSize;
		this.allRecordNo = allRecordNo;
		this.allPageNo = allPageNo;
		this.articles = articles;
	}
	public Page() {
		super();
	}
	
}
