package com.briup.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 使用ajax技术将系统的时间显示出来
 * @author wangfali
 *@version 1.0
 *@date 2017年3月18日
 */
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TimeServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("get方式");
			//获取参数
			String name = request.getParameter("name");
			String salray = request.getParameter("salray");
			//输出参数
			System.out.println("name:"+name+"salray:"+salray);
			//创建时间对象
			SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String format = sdf.format(new Date());
			//获取流对象
			PrintWriter writer = response.getWriter();
			//将时间写出
			writer.write(format);
			//刷新流
			writer.flush();
			//关闭流
			writer.close();
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get方式");
		//获取参数
		String name = request.getParameter("name");
		String salray = request.getParameter("salray");
		//输出参数
		System.out.println("name:"+name+"salray:"+salray);
		//创建时间对象
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = sdf.format(new Date());
		//获取流对象
		PrintWriter writer = response.getWriter();
		//将时间写出
		writer.write(format);
		//刷新流
		writer.flush();
		//关闭流
		writer.close();
		
	}
}
