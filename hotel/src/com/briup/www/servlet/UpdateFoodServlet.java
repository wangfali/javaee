package com.briup.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.briup.www.entity.Food;
import com.briup.www.service.impl.ImplFoodService;
/**
 * 保存更新的菜品
 * @author wangfali
 *@version 1.0
 *@date 2016年12月19日
 */
@WebServlet("/UpdateFoodServlet")
public class UpdateFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateFoodServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取传输的包装信息
		Food food = new Food();
		try {
			BeanUtils.populate(food, request.getParameterMap());
			//更新菜品
			new ImplFoodService().update(food);
			response.getWriter().write("<script type='text/javascript'>alert('更新成功！');location.href='"+request.getContextPath()+"/ToShowAllFoodServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('更新失败！');location.href='"+request.getContextPath()+"/ToShowAllFoodServlet';</script>");
			e.printStackTrace();
		}
	}

}
