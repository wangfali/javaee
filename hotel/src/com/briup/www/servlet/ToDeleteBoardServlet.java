package com.briup.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.dao.Impl.ImplBoardDao;
/**
 * 删除餐桌
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
@WebServlet("/ToDeleteBoardServlet")
public class ToDeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToDeleteBoardServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String parameter = request.getParameter("id");
		try {
			new ImplBoardDao().delete(Long.parseLong(parameter));
			response.getWriter().write("<script type='text/javascript'>alert('删除成功！');location.href='"+request.getContextPath()+"/ToShowAllBoardServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('删除失败！');location.href='"+request.getContextPath()+"/ToShowAllBoardServlet';</script>");
			e.printStackTrace();
		}
	}

}
