package briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import briup.Bean.Student;
import briup.common.HibernateSessionFactory;
import briup.common.exception.StudentServiceException;
import briup.service.IStudentService;
import briup.service.impl.StudentService;

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
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
			req.getRequestDispatcher("/success.html").forward(req, resp);
		}catch(StudentServiceException e){e.printStackTrace();
		req.setAttribute("msg", e.getMessage());
		req.getRequestDispatcher("/error.jsp").forward(req, resp);
		
		}
		PrintWriter out=resp.getWriter();
		out.println("TASerlet");
		out.close();
	}

}
