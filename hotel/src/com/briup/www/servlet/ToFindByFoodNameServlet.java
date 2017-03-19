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
 * 通过菜名查找菜
 * @author wangfali
 *@version 1.0
 *@date 2016年12月26日
 */
@WebServlet("/ToFindByFoodNameServlet")
public class ToFindByFoodNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ToFindByFoodNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取参数
		String parameter = request.getParameter("keyword");
		//查询数据
		try {
			List<Food> list = new ImplFoodService().FindAll(parameter+"%");
			System.out.println(list);
			//判断集合是否为空
			if(list.isEmpty()){
				//将没有找到结果信息封装
				request.setAttribute("error", "没有找到相应的结果！");
			}else{
				//将查询结果封装
				request.setAttribute("keyword", list);
			}
			//转发并且传值
			request.getRequestDispatcher("/sys/detail/findByFoodNameForFood.jsp").forward(request, response);
		} catch (Exception e) {
			//将错误信息弹出，并返回主页面
			response.getWriter().write("<script type='text/javascript'>alert('查询出错！请联系管理员'); location.href='/sys/detail/foodList.jsp';</script>");
			e.printStackTrace();
		}
	}

}
