package com.briup.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.entity.Board;
import com.briup.www.service.impl.ImplBoardService;
/**
 * 通过模糊查询餐桌的信息
 * @author wangfali
 *@version 1.0
 *@date 2016年12月26日
 */
@WebServlet("/ToFindByNameDoardServlet")
public class ToFindByNameDoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ToFindByNameDoardServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		response.setContentType("text/html;charset=utf-8");
		//获取参数
		String parameter = request.getParameter("keyword");
		//将参数代入并查询
		try {
			List<Board> list = new ImplBoardService().FindAll(parameter+"%");
			//判断查询结果是否为空
			if(list.isEmpty()){
			//将错误结果进行封装
			request.setAttribute("error","查询结果为空");
			}else{
			//将查询到的数据进行封装
			request.setAttribute("keyword", list);
			}
			//转发并且传值
			request.getRequestDispatcher("/sys/detail/findByNameForBoard.jsp").forward(request, response);
		} catch (Exception e) {
			//将错误信息弹出，并返回主页面
			response.getWriter().write("<script type='text/javascript'>alert('查询出错！请联系管理员'); location.href='/sys/detail/boardList.jsp';</script>");
			e.printStackTrace();
		}
	}

}
