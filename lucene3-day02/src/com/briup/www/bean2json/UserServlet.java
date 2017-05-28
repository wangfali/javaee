package com.briup.www.bean2json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//收集DataGrid向服务器发送的参数--page(当前页号)
		String page = request.getParameter("page");
		System.out.println(page+"=page");
		//收集DataGrid向服务器发送的参数--rows(当前需要显示的记录数)
		String rows = request.getParameter("rows");
		System.out.println("rows="+rows);
		List<User>users=new ArrayList<User>();
		users.add(new User(1, "wang", 100, "dw"));
		users.add(new User(2, "dads", 100, "qsadsa"));
		users.add(new User(3, "fds", 311, "dcsd"));
		users.add(new User(4, "wangs", 100, "dw"));
		users.add(new User(5, "dadsd", 100, "qsadsa"));
		users.add(new User(6, "fdsd", 311, "dcsd"));
		Map<String, Object> map=new HashMap<String,Object>();
		//集合的长度
		map.put("total", users.size());
		//集合的内容
		map.put("rows", users);
		JSONArray jsonArray = JSONArray.fromObject(map);
		String jsonJava = jsonArray.toString();
		//去除中括号
		jsonJava=jsonJava.substring(1, jsonJava.length()-1);
		//以流的方式将JSON文本输出到DateGrid组件中
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(jsonJava);
		writer.flush();
		writer.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
