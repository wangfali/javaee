package com.briup.www;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 高仿java核心标签if标签
 * @author wangfali
 *@version 1.0
 *@date 2016年11月29日
 */
public class IfTag extends SimpleTagSupport{
	/**
	 * 接收变量
	 */
	private boolean test;
	//赋值
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			getJspBody().invoke(null);
		}
	}
}
