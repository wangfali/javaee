package com.briup.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.briup.www.entity.Board;
import com.briup.www.service.impl.ImplBoardService;

@WebServlet("/ToSaveBoardServlet")
public class ToSaveBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ToSaveBoardServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Board board = new Board();
		try {
			BeanUtils.copyProperty(board, "boardName", request.getParameter("boardName"));
			System.out.println(board);
			new ImplBoardService().save(board);
			response.getWriter().write("<script type='text/javascript'>alert('添加成功！');location.href='"+request.getContextPath()+"/ToShowAllBoardServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('添加失败！');location.href='"+request.getContextPath()+"/ToShowAllBoardServlet';</script>");
			e.printStackTrace();
		}
	}

}
