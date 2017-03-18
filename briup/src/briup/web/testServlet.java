package briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public testServlet() {
        super();
        System.out.println("--创建testServlet------d---");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//Context context=new InitialContext();
			//DataSource  ds=(DataSource)context.lookup("java:comp/env/jdbc/DefaultDS");
			//Connection conn =ds.getConnection();
			//System.out.println(conn);
			System.out.println("aServlet----");
			System.out.println("request"+request);
			System.out.println("response"+response);
			System.out.println("Aservlet"+this);
			PrintWriter out=response.getWriter();
			out.print("hello");
			//out.flush();
			//out.close();
			System.out.println("---end---");
			//内部跳转 1.获取分发器 2.跳转
			RequestDispatcher dispatcher=request.getRequestDispatcher("b");
//			dispatcher.include(request, response);
			dispatcher.forward(request, response);
			//外部跳转
//			response.sendRedirect("/briup/b");
		}catch(Exception e){e.printStackTrace();}
		System.out.println("欢迎进入！");
	}

}
