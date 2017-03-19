package com.briup.www;

import com.opensymphony.xwork2.Action;

/**
 * 通配符的使用的实践
 * @author wangfali
 *@version 1.0
 *@date 2017年2月16日
 */
public class FiveAction implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("FiveAction.execute()");
		return "FiveAction";
	}

}
