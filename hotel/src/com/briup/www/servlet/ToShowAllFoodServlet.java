package com.briup.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.entity.Food;
import com.briup.www.service.impl.ImplFoodService;
/**
 * 查询所有的菜品
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
@WebServlet("/ToShowAllFoodServlet")
public class ToShowAllFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToShowAllFoodServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Food> list = new ImplFoodService().FindAll();
			request.setAttribute("foodList", list);
			request.getRequestDispatcher("/sys/detail/foodList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
