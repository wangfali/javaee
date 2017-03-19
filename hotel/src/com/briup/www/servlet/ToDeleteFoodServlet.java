package com.briup.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.service.impl.ImplFoodService;

@WebServlet("/ToDeleteFoodServlet")
public class ToDeleteFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToDeleteFoodServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取id
		String parameter = request.getParameter("id");
		//调用删除的方法
		try {
			new ImplFoodService().delete(Long.parseLong(parameter));
			response.getWriter().write("<script type='text/javascript'>alert('删除成功！');location.href='"+request.getContextPath()+"/ToShowAllFoodServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('删除失败！');location.href='"+request.getContextPath()+"/ToShowAllFoodServlet';</script>");
			e.printStackTrace();
		}
	}

}
