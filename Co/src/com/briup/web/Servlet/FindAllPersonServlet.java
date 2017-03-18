package com.briup.web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.web.Bean.person;
import com.briup.web.Dao.Impl.DataImpl;

/**
 * 查找所有的person的类
 * @author wangfali
 *@version 1.0
 *@date 2016年11月22日
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/FindAllPersonServlet" })
public class FindAllPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllPersonServlet() {
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
		//查询所有的数据
		List<person> list = new DataImpl().fillAll();
		//向用户返回数据
		PrintWriter writer = response.getWriter();
		String html="";
		html += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html += "<html xmlns='http://www.w3.org/1999/xhtml'>";
		html += "<head>";
		html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
		html += "<title>查询所有联系人</title>";
		html += "<style type='text/css'>";
		html += "	table td{";
		html += "		/*文字居中*/";
		html += "		text-align:center;";
		html += "	}";
		html += "	";
		html += "	/*合并表格的边框*/";
		html += "	table{";
		html += "		border-collapse:collapse;";
		html += "	}";
		html += "</style>";
		html += "</head>";
		html += "";
		html += "<body>";
		html += "<center><h3>查询所有联系人</h3></center>";
		html += "<table align='center' border='1' width='800px'>";
		html += "	<tr>";
		html += "    	<th>编号</th>";
		html += "        <th>姓名</th>";
		html += "        <th>电话</th>";
		html += "        <th>邮箱</th>";
		html += "        <th>QQ</th>";
		html += "        <th>操作</th>";
		html += "    </tr>";
		if(list!=null){
			for (person person : list) {
				html += "    <tr>";
				html += "    	<td>"+person.getIdString()+"</td>";
				html += "        <td>"+person.getNameString()+"</td>";
				html += "        <td>"+person.getPhoneString()+"</td>";
				html += "        <td>"+person.getEmailString()+"</td>";
				html += "        <td>"+person.getqQString()+"</td>";
				html += "        <td><a href='"+request.getContextPath()+"/QuerypersonServlet?id="+person.getIdString()+"'>修改</a>&nbsp;<a href='"+request.getContextPath()+"/DeletepersonServlet?id="+person.getIdString()+"'>删除</a></td>";
				html += "    </tr>";
			}
		}
		html += "    <tr>";
		html += "    	<td colspan='6' align='center'><a href='"+request.getContextPath()+"/addperson.html'>[添加联系人]</a></td>";
		html += "    </tr>";
		html += "</table>";
		html += "</body>";
		html += "</html>";
		writer.write(html);
	}

}
