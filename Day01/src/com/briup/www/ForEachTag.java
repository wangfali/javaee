package com.briup.www;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * foreach循环遍历的高仿类
 * @author wangfali
 *@version 1.0
 *@date 2016年11月29日
 */
public class ForEachTag extends SimpleTagSupport{
	private String var;
	private Object items;
	public void setVar(String var) {
		this.var = var;
	}
	public void setItems(Object items) {
		this.items = items;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//拿到页面域对象
		PageContext context=(PageContext)getJspContext();
		//判断集合的类型
		if(items instanceof List){
			List list=(List)items;
			for (Object object : list) {
				//把对象都放进域对象当中
				context.setAttribute(var, object);
				//将标签的内容输出
				getJspBody().invoke(null);
			}
		}
		if (items instanceof Map) {
			Map map=(Map)items;
			Set<Entry> entrySet = map.entrySet();
			Iterator<Entry> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				context.setAttribute("var",entry);
				getJspBody().invoke(null);
			}
			/*for (Entry entry : entrySet) {
				context.setAttribute("var",entry);
				getJspBody().invoke(null);
			}*/
		}
	}
}
