package briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionOne")
public class SessionOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SessionOne() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("UTF-8");
	System.out.println("---SessionOne----");
	System.out.println("一下是所有的cookie---");
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie cookie:cookies){
			System.out.println(cookie.getName()+":"+cookie.getValue());
			
		}
	}else {
		System.out.println("cookie is null");
	}
	System.out.println("获取Session");
	//1.jsessionid
	HttpSession session=request.getSession();
	session.setAttribute("name", "我的名字叫terry");
	System.out.println("该cookie为："+session.getId());
	response.sendRedirect("SessionTwo");
	}

}
