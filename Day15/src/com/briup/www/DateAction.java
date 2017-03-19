package com.briup.www;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts域对象的处理功能
 * @author wangfali
 *@version 1.0
 *@date 2017年2月15日
 */
public class DateAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//自动封装数据
	private String name;
	private int age;
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String execute() throws Exception {
		//获取相关的传入信息
		System.out.println(name);
		System.out.println(age);
		return SUCCESS;
	}
}
