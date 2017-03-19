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
public class Otherwise extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		//获得父类的变量
		ChooseTag chooseTag=(ChooseTag)getParent();
		if(!chooseTag.isFlag()){
			getJspBody().invoke(null);
		}
	}
}
