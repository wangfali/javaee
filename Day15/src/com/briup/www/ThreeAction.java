package com.briup.www;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 通配符的使用规则的实践
 * @author wangfali
 *@version 1.0
 *@date 2017年2月16日
 */
public class ThreeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		System.out.println("ThreeAction.execute()");
		return super.execute();
	}
}
