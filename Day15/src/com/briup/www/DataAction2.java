package com.briup.www;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Strust数据处理的方法
 * @author wangfali
 *@version 1.0
 *@date 2017年2月16日
 */
public class DataAction2 extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	private static final long serialVersionUID = 1L;
	private Map<String, Object>request;
	private Map<String, Object>session;
	private Map<String, Object>application;
	@Override
	public String execute() throws Exception {
		//方法一获取Servlet api
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		//方法二使用解耦的方法
		ActionContext context = ActionContext.getContext();
		Map<String, Object> application2 = context.getApplication();
		Map<String, Object> session2 = context.getSession();
		Map<String, Object> request1 = context.getContextMap();
		//方法三实现相应的接口
		return SUCCESS;
	}
	//当Strust运行的时候会把map集合载入 先运行拦截器在运行方法
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
	
}
