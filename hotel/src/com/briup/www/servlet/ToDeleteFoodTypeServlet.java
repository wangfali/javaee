package com.briup.www.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.service.impl.ImplFoodTypeService;
/**
 * 删除菜系
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
@WebServlet("/ToDeleteFoodTypeServlet")
public class ToDeleteFoodTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToDeleteFoodTypeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		try {
			new ImplFoodTypeService().delete(Integer.parseInt(id));
			response.getWriter().write("<script type='text/javascript'>alert('删除成功！');location.href='"+request.getContextPath()+"/ToShowAllFoodTpyeServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('删除失败！');location.href='"+request.getContextPath()+"/ToShowAllFoodTpyeServlet';</script>");
			e.printStackTrace();
		}
	}

}
