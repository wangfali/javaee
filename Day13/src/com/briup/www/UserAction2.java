package com.briup.www;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Strust日期转换类型
 * @author wangfali
 *@version 1.0
 *@date 2017年1月19日
 */
public class UserAction2 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//创建类型转换对象
	UserBean userBean=new UserBean();
	//set构造器
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	//get构造器
	public UserBean getUserBean() {
		return userBean;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("年龄"+userBean.getAge());
		System.out.println("姓名"+userBean.getName());
		System.out.println("生日"+userBean.getBrith());
		return SUCCESS;
	}
}
