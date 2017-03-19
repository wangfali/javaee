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

@WebServlet("/ToShowAllFoodTpyeServlet")
public class ToShowAllFoodTpyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ToShowAllFoodTpyeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodType> list=null;
		try {
			list = new ImplFoodTypeService().FindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("FoodTypeAll", list);
		request.getRequestDispatcher("/sys/detail/cuisineList.jsp").forward(request, response);
	}

}
