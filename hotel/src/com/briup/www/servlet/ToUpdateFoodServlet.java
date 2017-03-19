package com.briup.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.briup.www.entity.Food;
import com.briup.www.entity.FoodType;
import com.briup.www.service.impl.ImplFoodTypeService;

/**
 * 更新菜品
 * 
 * @author wangfali
 * @version 1.0
 * @date 2016年12月19日
 */
@WebServlet("/ToUpdateFoodServlet")
public class ToUpdateFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ToUpdateFoodServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Food food = new Food();
		try {
			//将请求的数据进行包装
			BeanUtils.copyProperty(food, "foodName", request.getParameter("foodName"));
			BeanUtils.copyProperty(food, "foodType", request.getParameter("foodType"));
			BeanUtils.copyProperty(food, "imagePath", request.getParameter("imagePath"));
			BeanUtils.copyProperty(food, "price", request.getParameter("price"));
			BeanUtils.copyProperty(food, "vipPrice", request.getParameter("vipPrice"));
			BeanUtils.copyProperty(food, "text", request.getParameter("text"));
			//查询所有菜系，将其保存到域对象中
			List<FoodType> all = new ImplFoodTypeService().FindAll();
			System.out.println(food);
			//保存food对象
			request.setAttribute("food", food);
			//保存foot
			request.setAttribute("FoodType", all);
			request.getRequestDispatcher("/sys/detail/updateFood.jsp").forward(request,
					response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
