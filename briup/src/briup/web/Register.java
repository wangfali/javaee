package briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import briup.Bean.Student;
import briup.common.exception.StudentServiceException;
import briup.service.IStudentService;
import briup.service.impl.StudentService;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
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
	//1.开启Session
	
			//2.获取参数
			//String name=req.getParameter("name");
			//String password=req.getParameter("password");
			String name="wangfali";
			String password="123456";
			//3 封装对象
			Student stu=new Student();
			stu.setName(name);
			stu.setPassword(password);
			//调用service层代码 完成逻辑
			IStudentService service=new StudentService();
			try{
				service.register(stu);
				System.out.println("保存成功！");
				//5.页面跳转
				request.getRequestDispatcher("/success.html").forward(request,response);
			}catch(StudentServiceException e){e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
			}
			PrintWriter out=response.getWriter();
			out.println("TASerlet");
			out.close();
		}

	}


