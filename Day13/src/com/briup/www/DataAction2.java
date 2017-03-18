package com.briup.www;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Strust数据处理解耦的方法
 * @author wangfali
 *@version 1.0
 *@date 2017年1月17日
 */
public class DataAction2 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		//获取请求域对象
		Map<String, Object> request = context.getContextMap();
		//获取会话域对象
		Map<String, Object> session = context.getSession();
		//获取全局域对象
		Map<String, Object> application = context.getApplication();
		//请求对象中的数据操作
		request.put("request_data2","request_data2");
		session.put("session_data2", "session_data2");
		application.put("application_data", "appliction_data2");
		return SUCCESS;
	}
}
