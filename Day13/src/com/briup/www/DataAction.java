package com.briup.www;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Strust中数据的操作
 * 1.获取servletapi对数据进行操作
 * 2.直接使用解耦的方法
 * 3.实现相关的接口
 * @author wangfali
 *@version 1.0
 *@date 2017年1月17日
 */
public class DataAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		//获取请求域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取全局域对象
		ServletContext application = ServletActionContext.getServletContext();
		//获取会花域对象
		HttpSession session = request.getSession();
		//对域对象进行数据操作
		request.setAttribute("request_data", "requset_data");
		application.setAttribute("application_data", "application_data");
		session.setAttribute("session_data", "session_data");
		return SUCCESS;
	}
}
