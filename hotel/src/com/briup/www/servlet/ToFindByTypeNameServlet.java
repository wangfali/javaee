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
/**
 * 通过菜系名查找菜系
 * @author wangfali
 *@version 1.0
 *@date 2016年12月26日
 */
@WebServlet("/ToFindByTypeNameServlet")
public class ToFindByTypeNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToFindByTypeNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码问题
		response.setContentType("text/html;chaeset=utf-8");
		//获取参数
		String parameter = request.getParameter("keyword");
		//查询数据
		try {
			List<FoodType> list = new ImplFoodTypeService().FindAll(parameter+"%");
			//判断是否集合是否为空
			if(list.isEmpty()){
				//将没有结果的信息输出
				request.setAttribute("error","查询结果为空");
			}else{
			//将查询到的数据进行封装
			request.setAttribute("keyword", list);
			}
			//转发并且传值
			request.getRequestDispatcher("/sys/detail/findByNameForFoodType.jsp").forward(request, response);
		} catch (Exception e) {
			//将错误信息弹出，并返回主页面
			response.getWriter().write("<script type='text/javascript'>alert('查询出错！请联系管理员'); location.href='/sys/detail/cuisineList.jsp';</script>");
			e.printStackTrace();
		}
		
	}

}
