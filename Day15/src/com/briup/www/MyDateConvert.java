package com.briup.www;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Strust时间类型的转换方式
 * @author wangfali
 *@version 1.0
 *@date 2017年2月16日
 */
public class MyDateConvert extends StrutsTypeConverter{
	//从字符串类型转换成其他数据类型
	private SimpleDateFormat[] df={new SimpleDateFormat("yyyyMMdd"),
			new SimpleDateFormat("yyyy年MM月dd日")};
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		//判断转换数据的源不能为空
		if(values.length<1||values==null){
			return null;
		}
		//判断转换数据的类型是否为日期类型
		if(Date.class!=toClass){
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		for(int i=0;i<df.length;i++){
			try {
				dateFormat.parse(values[i]);
			} catch (ParseException e) {
				continue;
			}
		}
		return null;
	}
	//从其他数据类型转换成为字符串类型
	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		return null;
	}
}
