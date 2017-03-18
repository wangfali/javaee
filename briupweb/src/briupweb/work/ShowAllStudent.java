package briupweb.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowAllStudent")
public class ShowAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowAllStudent() {
        super();
        System.out.println("你已经进入初始化阶段！");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}
	/*
	 * 查找所有学生，并且回显到页面中**/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("你已经进入传值阶段！");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wangfali","root","root");
				System.out.println(conn);
				String sql="select * from briupstudent";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				System.out.println("你进入第一个try!");
				while(rs.next()){
					System.out.println("从数据库中能够提取出数据！");
					String name=rs.getString("name");
					String password=rs.getString("password");
					out.println(name+","+password);
					System.out.println(name+","+password);
				}
				if(rs.next()){
					System.out.println("有数据正在提取！");
				}else{System.out.println("没有数据被提取出来！");}
			}finally{
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
