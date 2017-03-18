package briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTwoServlet")
public class CookieTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTwoServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("--------CookieTwo-----");
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			System.out.println("这是游览器传递来的cookie");
			for(Cookie cookie: cookies){
				String name=cookie.getName();
				String value=cookie.getValue();
				System.out.println(name+":"+value+" ");
				
			}
			
		}else{
			System.out.println("Cookie is null");
		}
	}

}
