package com.briup.web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.briup.web.Bean.person;
import com.briup.web.Dao.Impl.DataImpl;

/**
 * 通过id查找对象
 * @author wangfali
 *@version 1.0
 *@date 2016年11月22日
 */
@WebServlet("/FindByIdServlet")
public class FindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//夺取相应的属性
		String id = request.getParameter("id");
		//通过id查找数据
		PrintWriter writer = response.getWriter();
		String html="";
		person person = new DataImpl().findById(id);
		html += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html += "<html xmlns='http://www.w3.org/1999/xhtml'>";
		html += "<head>";
		html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
		html += "<title>修改联系人</title>";
		html += "</head>";
		html += "";
		html += "<body>";
		html += "<center><h3>修改联系人</h3></center>";
		html += "<form action='"+request.getContextPath()+"/UpdatepersonServlet' method='post'>";
		//注意：添加id的隐藏域
		html += "<input type='hidden' name='id' value='"+person.getIdString()+"'/>";
		html += "<table align='center' border='1' width='300px'>";
		html += "    <tr>";
		html += "    	<th>姓名</th>";
		html += "        <td><input type='text' name='name' value='"+person.getNameString()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>电话</th>";
		html += "        <td><input type='text' name='phone' value='"+person.getPhoneString()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>邮箱</th>";
		html += "        <td><input type='text' name='email' value='"+person.getEmailString()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>QQ</th>";
		html += "        <td><input type='text' name='qq' value='"+person.getqQString()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "        <td colspan='2' align='center'>";
		html += "        <input type='submit' value='保存'/>&nbsp;";
		html += "        <input type='reset' value='重置'/></td>";
		html += "    </tr>";
		html += "</table>";
		html += "</form>";
		html += "</body>";
		html += "</html>";
		writer.write(html);
	}

}
