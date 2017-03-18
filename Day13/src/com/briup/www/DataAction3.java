package com.briup.www;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * strust数据操作实现接口
 * @author wangfali
 *@version 1.0
 *@date 2017年1月17日
 */
public class DataAction3 extends ActionSupport implements RequestAware,ApplicationAware,SessionAware{
	private static final long serialVersionUID = 1L;
	private Map<String, Object>session;
	private Map<String, Object>request;
	private Map<String, Object>application;
	@Override
	public void setSession(Map<String, Object>session) {
		this.session=session;
		
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
	@Override
	public String execute() throws Exception {
		request.put("request_data3", "request_data3");
		session.put("session_data3", "session_data3");
		application.put("application_data3","application_data3");
		return SUCCESS;
	}
}
