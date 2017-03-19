package com.briup.www.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.briup.www.entity.Board;
import com.briup.www.service.impl.ImplBoardService;
/**
 * 退订餐桌
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
@WebServlet("/ToReflectBoardServlet")
public class ToReflectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ToReflectBoardServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得对象信息进行封装
		response.setContentType("text/html;charset=utf-8");
		Board board = new Board();
		try {
			ConvertUtils.register(new DateLocaleConverter(),Date.class);
			BeanUtils.populate(board, request.getParameterMap());
			board.setState(0);
			board.setTime(null);
			new ImplBoardService().update(board);
			response.getWriter().write("<script type='text/javascript'>alert('退桌成功！');location.href='"+request.getContextPath()+"/ToShowAllBoardServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('退桌失败！');location.href='"+request.getContextPath()+"/ToShowAllBoardServlet';</script>");
			e.printStackTrace();
		}
	}

}
