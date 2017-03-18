package briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import briup.Bean.Student;
import briup.common.exception.StudentServiceException;
import briup.service.IStudentService;
import briup.service.impl.StudentService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
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
	String name=request.getParameter("username");
	String password=request.getParameter("password");
	IStudentService studentService=new StudentService();
	try{
		//当点击登陆时，Service层会返回会一个Student对象
		//如果没有返回对象将会抛出异常让一下的对象进行捕获
	Student stu= studentService.Login(name, password);
	//获取Session
	HttpSession session=request.getSession();
	//将当前登陆的用户信息存放到session当中
	session.setAttribute("Student", stu);
	//页面发生跳转
	response.sendRedirect("main.jsp");
	}catch(StudentServiceException e){
		//打印出异常的原因
		e.printStackTrace();
		//在请求中加入一个错误
		request.setAttribute("msg", e.getMessage());
		//页面发生内部跳转将其转到错误界面
		request.getRequestDispatcher("/error.jsp").forward(request, response);
		
	}
	}
	}


