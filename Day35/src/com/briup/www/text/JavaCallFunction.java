package com.briup.www.text;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.briup.www.util.DatabaseConnetion;

/**
 * 调用方法
 * @author wangfali
 *@version 1.0
 *@date 2017年3月18日
 */
public class JavaCallFunction {
	public static void main(String[] args) {
		//查询api可以得到调用函数的方式
		String sql="{?=call hello(?)}";
		try {
			//获取链接
			Connection conn = DatabaseConnetion.getConnection();
			//调用函数 调用函数
			CallableStatement call = conn.prepareCall(sql);
			//设置语句的参数
			call.registerOutParameter(1, Types.VARCHAR);
			call.setString(2, "zhaojun");
			//执行参数
			call.execute();
			//获取参数
			String str = call.getString(1);
			System.out.println("输出的数据为！"+str);
			//DatabaseConnetion.close(conn, null, null);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
