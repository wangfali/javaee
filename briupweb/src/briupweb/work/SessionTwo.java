package briupweb.work;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTwo")
public class SessionTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionTwo() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		System.out.println("SessionTwo");
		//分别从request,session,servletContext中获取数据
		String key1= (String) request.getAttribute("key1");
		HttpSession session=request.getSession();
		String key2=(String) session.getAttribute("key2");
		ServletContext context=getServletContext();
		String key3=(String) context.getAttribute("key3");
		System.out.println("key1"+key1);
		System.out.println("key2"+key2);
		System.out.println("key3"+key3);
		
	}

}
