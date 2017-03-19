package com.briup.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * jquery ajax验证数据
 * @author wangfali
 *@version 1.0
 *@date 2017年3月18日
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//提交方式为post
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//因为是post方式请求，不需要进行转码
		//获取参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		//设置返回值
		response.setContentType("text/html;charset=utf-8");
		//获取流对象
		PrintWriter pw = response.getWriter();
		//判断用户名和密码是否正确、
		if("王法立".equals(userName)&&"123456".equals(password)){
			//返回验证正确
			pw.write("验证通过！");
		}else{
			//返回验证失败
			pw.write("验证失败！用户名或密码错误，请核对");
		}
		//刷新流和关闭流
		pw.flush();
		pw.close();
	}

}
