package com.briup.web.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.web.Bean.person;
import com.briup.web.Dao.Impl.DataImpl;

/**
 * 添加用户对象的类
 * @author wangfali
 *@version 1.0
 *@date 2016年11月22日
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddPeronServlet" })
public class AddPeronServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPeronServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取参数
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		//封装对象
		person person = new person();
		person.setEmailString(email);
		person.setNameString(name);
		person.setPhoneString(phone);
		person.setqQString(qq);
		//将对象进行存储
		new DataImpl().addContact(person);
		//将数据重定向
		response.sendRedirect(request.getContextPath()+"/index.html");
	}

}
