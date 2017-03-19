package com.briup.www.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

/**
 * 数据库链接工具
 * @author wangfali
 *@version 1.0
 *@date 2017年3月18日
 */
public class DatabaseConnetion {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/wangfali";
	private static String user = "root";
	private static String password = "root";
	//静态代码块
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//创建静态方法
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, user, password);
	}
	public static void close(Connection conn,Statement sta,ResultSet resultSet) throws Exception{
		//关闭资源
		if(resultSet!=null){
			resultSet.close();
		}
		if(sta!=null){
			sta.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
