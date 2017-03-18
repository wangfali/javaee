package briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import briup.Bean.Student;
/*
 * 跳转到登录页面**/
@WebServlet("/ToLogin")
public class ToLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public ToLoginServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Student stu=(Student) session.getAttribute("student");
		//如果Session中已经保存了student，说明该用户在线，无需再次登录
		if(stu==null){
			request.getRequestDispatcher("/WEB-INF/login.jsp");
			
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
