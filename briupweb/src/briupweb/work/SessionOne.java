package briupweb.work;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionOne")
public class SessionOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SessionOne() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		System.out.println("------sessionone---");
		//向request,session,servletcontext中分别保存数据
		//观察数据保存的寿命周期
		request.setAttribute("key1", "this is requset");
		HttpSession session=request.getSession();
		session.setAttribute("key2", "this is session");
		ServletContext context=getServletContext();
		context.setAttribute("key3", "this is ServletContext");
		//发生跳转调到SessionTwo
		
		//request.getRequestDispatcher("/SessionTwo").forward(request, response);
		//重写URL,(相当于在你的访问路径的后面接上Jsessionid适用于当关闭cookie时的访问)
		String url=response.encodeRedirectURL("SessionTwo");
		//外部跳转
		response.sendRedirect(url);
		
		
		
	}

}
