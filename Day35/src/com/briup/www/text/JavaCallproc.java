package com.briup.www.text;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.briup.www.util.DatabaseConnetion;

/**
 * 调用存储过程
 * @author wangfali
 *@version 1.0
 *@date 2017年3月18日
 */
public class JavaCallproc {
	public static void main(String[] args) {
		//查询api可以得到调用存储过程的方式
		String sql="{call simple(?)}";
		try {
			//获取链接
			Connection conn = DatabaseConnetion.getConnection();
			//调用核心函数
			CallableStatement call = conn.prepareCall(sql);
			//这个输出的?设置类型，?号下标从1开始
			call.registerOutParameter(1, Types.INTEGER);
			//执行过程的调用
			call.execute();
			//接收返回数据
			int int1 = call.getInt(1);
			//显示
			System.out.println("共有"+int1+"条数据");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
