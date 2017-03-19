package com.briup.www;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 多项选择判断的高仿类
 * @author wangfali
 *@version 1.0
 *@date 2016年11月29日
 */
public class ChooseTag extends SimpleTagSupport {
	/**
	 * 设置一个变量用于存储需要判断的值
	 */
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void doTag() throws JspException, IOException {
		/**
		 * 将标签体内容进行输出内容进行输出
		 */
		getJspBody().invoke(null);
	}
}
