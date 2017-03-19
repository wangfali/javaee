package com.briup.www;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 域对象的使用方法Strust
 * @author wangfali
 *@version 1.0
 *@date 2017年2月15日
 */
public class SectionAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//执行的方法
	@Override
	public String execute() throws Exception {
		//获取与对象
		ActionContext context = ActionContext.getContext();
		//请求的域对象
		Map<String, Object> request = context.getContextMap();
		//获取请求的域对象
		Map<String, Object> session = context.getSession();
		//获取全局的域对象
		Map<String, Object> application = context.getApplication();
		//将数据存入域对象中
		request.put("request", "request_data");
		session.put("session", "session_data");
		application.put("application", "application_data");
		return SUCCESS;
	}
}
