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
/**
 * 更新菜系
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
@WebServlet("/ToUpdateFoodTypeServlet")
public class ToUpdateFoodTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ToUpdateFoodTypeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			FoodType foodType = new FoodType();
			BeanUtils.copyProperty(foodType, "typeName",request.getParameter("typeName"));
			BeanUtils.copyProperty(foodType, "id",request.getParameter("id"));
			new ImplFoodTypeService().update(foodType);
			response.getWriter().write("<script type='text/javascript'>alert('更新成功！');location.href='"+request.getContextPath()+"/ToShowAllFoodTpyeServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('更新失败！');location.href='"+request.getContextPath()+"/ToShowAllFoodTpyeServlet';</script>");
			e.printStackTrace();
		}
	}

}
