package briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showBook")
public class showBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public showBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
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

		if(id.equals("1001")){
			request.setAttribute("book", "这本书不错！");
		}else if(id.equals("1002")){
			request.setAttribute("book", "这本书是一个不错的学习方法！");
			
		}
		request.getRequestDispatcher("/day8/showBook.jsp").forward(request, response);
		
	}

}
