package com.briup.www;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 多项判断选择的子标签
 * @author wangfali
 *@version 1.0
 *@date 2016年11月29日
 */
public class WhenTag extends SimpleTagSupport{
	/**
	 * 设置一个变量用于传值
	 */
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		if (test) {
			getJspBody().invoke(null);
		}
		//获取父类 将判断值放入其中
		ChooseTag ChooseTag=(ChooseTag)getParent();
		ChooseTag.setFlag(test);
	}
}
