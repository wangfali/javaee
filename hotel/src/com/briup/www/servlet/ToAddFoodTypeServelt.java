package com.briup.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.briup.www.entity.FoodType;
import com.briup.www.service.impl.ImplFoodTypeService;

@WebServlet("/ToAddFoodTypeServelt")
public class ToAddFoodTypeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToAddFoodTypeServelt() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		FoodType foodType = new FoodType();
		try {
			BeanUtils.copyProperty(foodType, "typeName", request.getParameter("typeName"));
			new ImplFoodTypeService().save(foodType);
			response.getWriter().write("<script type='text/javascript'>alert('添加成功！');location.href='"+request.getContextPath()+"/ToShowAllFoodTpyeServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('该菜系名已经存在！');location.href='"+request.getContextPath()+"/ToShowAllFoodTpyeServlet';</script>");
			e.printStackTrace();
		}
	}

}
