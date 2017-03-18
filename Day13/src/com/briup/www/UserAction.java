package com.briup.www;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Strust中的Action开发方式有3种 
 * 1.继承ActionSupport
 * 2.继承Action接口
 * 3.没有继承任何的类和实现任何的接口
 * @author wangfali
 *@version 1.0
 *@date 2017年1月16日
 */
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String Login(){
		System.out.println("UserAction.Login()"+name);
		return SUCCESS;
	}
	public String register(){
		System.out.println("UserAction.register()"+name);
		return SUCCESS;
	}
}
