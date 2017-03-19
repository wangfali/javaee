package com.briup.www.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * 请求数据的封装，其中使用了泛型
 * @author wangfali
 *@version 1.0
 *@date 2016年12月13日
 */

public class WebUtil {
	public static <T> T copyToBean(HttpServletRequest request,Class<T> clazz){
		try {
			T t=clazz.newInstance();
			ConvertUtils.register(new DateLocaleConverter(), clazz);
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
