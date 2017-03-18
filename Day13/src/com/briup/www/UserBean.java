package com.briup.www;

import java.util.Date;

/**
 * Strust数据转换的javabean类
 * @author wangfali
 *@version 1.0
 *@date 2017年1月19日
 */
public class UserBean {
	private String name;
	private int age;
	private Date brith;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBrith() {
		return brith;
	}
	public void setBrith(Date brith) {
		this.brith = brith;
	}
	
}
