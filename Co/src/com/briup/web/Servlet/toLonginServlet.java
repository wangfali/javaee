package com.briup.web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class toLonginServlet
 */
@WebServlet("/toLonginServlet")
public class toLonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toLonginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//创建一个输出对象
		PrintWriter writer = response.getWriter();
		//获取传入的信息
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		//判断验证(注意相应只能执行一次！)
		if(name.equals("admin")&& password.equals("admin")){
			writer.write("<script type='text/javascript'>alert('登录成功！');location.href='index.html';</script>");
			//request.getRequestDispatcher("index.html").forward(request, response);
		}else {
			writer.write("<script type='text/javascript'>alert('登录失败失败');location.href='one.html'</script>");
			//response.sendRedirect("one.html");
		}
	}

}
