package com.briup.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.entity.Food;
import com.briup.www.entity.PageBean;
import com.briup.www.service.impl.ImplFoodService;
/**
 * 分页
 * @author wangfali
 *@version 1.0
 *@date 2016年12月23日
 */
@WebServlet("/ToShowAllFoodPageServlet")
public class ToShowAllFoodPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ToShowAllFoodPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取第一页的分页消息并进行封装
		PageBean<Food> pageBean = new PageBean<Food>();
		//获取分页的信息
		try {
			new ImplFoodService().getAll(pageBean);
			//将对象封装进行转发
			request.setAttribute("pageBean", pageBean);
			//转发
			request.getRequestDispatcher("/app/detail/caidan.jsp").forward(request, response);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
