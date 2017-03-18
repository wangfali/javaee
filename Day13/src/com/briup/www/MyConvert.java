package com.briup.www;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Strust数据类型的转换自定义类
 * @author wangfali
 *@version 1.0
 *@date 2017年1月19日
 */
public class MyConvert extends StrutsTypeConverter{
	//先定义项目日期的转换类型
	DateFormat[] df={new SimpleDateFormat("yyyy-MM-dd"),new SimpleDateFormat("yyyyMMdd"),
			new SimpleDateFormat("yyyy年MM月dd日")};
	@SuppressWarnings("null")
	@Override
	public Object convertFromString( Map context, String[] values, Class toClass) {
		//判断内容不能为空
		if(values==null||values.length==0){
			return null;
		}
		//判断类型必须为Data类型
		if(Date.class!=toClass){
			return null;
		}
		for(int i=0;i<df.length;i++){
			try{
				return df[i].parse(values[0]);
			}
		catch (Exception e) {
			continue;
		}
			}
		return null;
	}
	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}

}
