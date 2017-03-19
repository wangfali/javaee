package com.briup.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.briup.www.entity.FoodType;

@WebServlet("/ToUpdateCuisineServlet")
public class ToUpdateCuisineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToUpdateCuisineServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodType foodType = new FoodType();
		try {
			BeanUtils.copyProperty(foodType, "typeName",request.getParameter("typeName"));
			BeanUtils.copyProperty(foodType, "id",request.getParameter("id"));
			request.setAttribute("foodType", foodType);
			request.getRequestDispatcher("/sys/detail/updateCuisine.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
