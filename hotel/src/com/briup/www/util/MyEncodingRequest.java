package com.briup.www.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 解决乱码问题
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
public class MyEncodingRequest extends HttpServletRequestWrapper{

	public MyEncodingRequest(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String name) {
		String str=super.getParameter(name);
		if(str!=null&&!"".equals(str.trim())){
		try {
			str= new String(str.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		}
		return str;
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		try{

			Map<String,String[]> map =super.getParameterMap();  //接受客户端的数据
			Map<String,String[]> newmap = new HashMap<String,String[]>();   
			for(Map.Entry<String, String[]> entry : map.entrySet()){
			String name = entry.getKey();
			String values[] = entry.getValue();
			if(values==null){
			newmap.put(name, new String[]{});
			continue;
			}
			String newvalues[] = new String[values.length];
			for(int i=0; i<values.length;i++){
			String value = values[i];
			value = new String(value.getBytes("iso8859-1"),"utf-8");
			newvalues[i] = value; //解决乱码后封装到Map中
			}
			newmap.put(name, newvalues);
			}
			return newmap;
			}catch (Exception e) {
			throw new RuntimeException(e);
			}
			}
	}

