package briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name="terry";
		//
		Cookie[] cookies =request.getCookies();
		if(cookies!=null){
			for(Cookie cookie :cookies){
				String name1=cookie.getName();
				String value=cookie.getValue();
				System.out.println(name1+"name1");
				System.out.println(value+"value");
			}
		}else{
			System.out.println("cookie is null");
		}
		//标记此处
		PrintWriter out=response.getWriter();
		out.print("登录成功开始发生转换！");
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		
		//将name对象保存到request对象当中
		//request.setAttribute("name", name);
		//内部跳转 1.跳转到main.jsp
		request.getRequestDispatcher("/day8/main.jsp").forward(request, response);
	}

}
