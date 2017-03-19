package com.briup.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.entity.FoodType;
import com.briup.www.service.impl.ImplFoodTypeService;

@WebServlet("/ToShowAddFoodServlet")
public class ToShowAddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToShowAddFoodServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<FoodType>list = new ImplFoodTypeService().FindAll();
			//将集合保存在域对象中
			request.setAttribute("foodType",list );
			request.getRequestDispatcher("/sys/detail/saveFood.jsp").forward(request, response);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
