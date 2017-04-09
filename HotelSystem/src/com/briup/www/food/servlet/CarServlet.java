package com.briup.www.food.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CarServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//并流
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应返回的信息
		response.setContentType("text/html;charset=utf-8");
		//获取传入的参数
		String str=(String) request.getParameter("id");
		//获取键
		String count= (String)request.getParameter("count");
		//创建一个session
		HttpSession session = request.getSession(true);
		//将所获取到的数据加入到session当中
		session.setAttribute(count, str);
		//返回响应信息
		PrintWriter writer = response.getWriter();
		writer.write("success");
		writer.close();
	}

}
