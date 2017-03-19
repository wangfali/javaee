package com.briup.www.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库操作工具类
 * @author wangfali
 *@version 1.0
 *@date 2016年12月14日
 */
public class DataBaseConnectFactry {
	public static Connection getConnection() throws Exception{
		//创建C3P0数据库连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection connection = dataSource.getConnection();
		return connection;
	}
	public static void close(Connection conn,Statement stat,ResultSet rs){
		//关闭资源
		try{
		if(rs!=null){
			rs.close();
			rs=null;
		}if(stat!=null){
			stat.close();
			stat=null;
		}if(conn!=null){
			conn.close();
			conn=null;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
