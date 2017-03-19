package com.briup.www;
/**
 * 学生类，用于测试foreach循环的方法
 * @author wangfali
 *@version 1.0
 *@date 2016年11月29日
 */
public class Student {
	private String nameString;
	private String passwordString;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", passwordString="
				+ passwordString + "]";
	}
	/**
	 * @param nameString 用户名
	 * @param passwordString 密码
	 */
	public Student(String nameString, String passwordString) {
		super();
		this.nameString = nameString;
		this.passwordString = passwordString;
	}
	
	public Student() {
		super();
	}
	
}
