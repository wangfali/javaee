package com.briup.www;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 对Action类的环境开发
 * @author wangfali
 *@version 1.0
 *@date 2017年2月15日
 */
public class OneAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//开发执行的函数
	@Override
	public String execute() throws Exception {
		System.out.println("欢迎使用，你已经成功的使用该文件进行数据操作");
		return "SUCCESS";
	}
}
