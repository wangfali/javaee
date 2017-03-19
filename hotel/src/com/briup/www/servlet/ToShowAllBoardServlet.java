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
 * 添加餐桌
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
@WebServlet("/ToShowAllBoardServlet")
public class ToShowAllBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ToShowAllBoardServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Board> list = new ImplBoardService().FindAll();
			request.setAttribute("boardList", list);
			request.getRequestDispatcher("/sys/detail/boardList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
