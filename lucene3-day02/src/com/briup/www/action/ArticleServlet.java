package com.briup.www.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.www.entity.Page;
import com.briup.www.service.ArticleService;

import net.sf.json.JSONArray;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			// 获取关键字
			String keywords = request.getParameter("keywords");
			if (keywords == null || keywords.trim().length() == 0) {
				keywords = "培训";// 默认索引
			}
			// 获取当前页号
			String parameter = request.getParameter("page");
			if (parameter == null || parameter.trim().length() == 0) {
				parameter = "1";// 默认值
			}
			// 调用业务层
			ArticleService articleService = new ArticleService();
			Page page = articleService.show(keywords, Integer.parseInt(parameter));
			// 创建map集合
			Map<String, Object> map = new HashMap<String, Object>();
			// 总记录数
			map.put("total", page.getAllRecordNo());
			// 结果集
			map.put("rows", page.getArticles());
			JSONArray jsonArray = JSONArray.fromObject(map);
			String json = jsonArray.toString();
			// 去除两边中夸好
			json = json.substring(1, json.length() - 1);
			PrintWriter writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
