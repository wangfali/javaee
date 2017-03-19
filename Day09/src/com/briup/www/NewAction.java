package com.briup.www;

import com.opensymphony.xwork2.ActionSupport;

/**
 * strust的使用
 * @author wangfali
 *@version 1.0
 *@date 2016年12月28日
 */
public class NewAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {
		System.out.println("已经开始使用该功能！");
		return "success";
	}
}
