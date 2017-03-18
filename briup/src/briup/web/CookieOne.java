package briup.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieOne")
public class CookieOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CookieOne() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("UTF-8");
		 //获取关键字
		 String keys=request.getParameter("keys");

		 //从请求中获取Cookie值
		 Cookie[] cookies=request.getCookies();
		 //创建一个变量用于存储cookie值
		 String val=null;
		 if(cookies!=null){
			//遍历cookie	
			 System.out.println("这是游览器传递来的cookie");
			//如果cookie的key	值为“keys”,将之前保存的cookie输出
			 for(Cookie cookie1: cookies){
					if(cookie1.getName().equals("keys")){
						val=cookie1.getValue();
						
					break;
					}
				}
		 }else{System.out.println("Cookie is null");
		 }
		 URLEncoder.encode(val+","+keys, "UTF-8");
		 Cookie cookie=new Cookie("keys",val+","+ keys);
		 cookie.setMaxAge(360000);
		 //将cookie内容放入到内存当中
		 response.addCookie(cookie);
	}

}
