package com.briup.www.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.briup.www.entity.Food;
import com.briup.www.service.impl.ImplFoodService;
/**
 * 添加菜品
 * @author wangfali
 *@version 1.0
 *@date 2016年12月19日
 */
@WebServlet("/ToAddFoodServlet")
public class ToAddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ToAddFoodServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Food food = new Food();
		try {
			BeanUtils.populate(food, request.getParameterMap());
			new ImplFoodService().save(upload(request, food));
			response.getWriter().write("<script type='text/javascript'>alert('添加成功！');location.href='"+request.getContextPath()+"/ToShowAllFoodServlet';</script>");
		} catch (Exception e) {
			response.getWriter().write("<script type='text/javascript'>alert('添加失败！');location.href='"+request.getContextPath()+"/ToShowAllFoodServlet';</script>");
			e.printStackTrace();
		}
	}
	private Food upload(HttpServletRequest request,Food food) throws Exception{
		//文件上传
		//创建文件上传工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建文件核心对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置上传文件的基本信息
		upload.setFileSizeMax(60*1024*1024);
		upload.setSizeMax(80*1024*1024);
		upload.setHeaderEncoding("utf-8");
		//判断上传的是否是普通的文件
		if(ServletFileUpload.isMultipartContent(request)){
			//将请求的信息进行分解
				List<FileItem> list = upload.parseRequest(request);
				//遍历集合 判断是否是表单元素
				for (FileItem fileItem : list) {
					if(fileItem.isFormField()){
						String option=fileItem.getFieldName();
						if("foodType".equals(option)){
							food.setFoodType(new String(fileItem.getString().getBytes("ISO8859-1"),"UTF-8"));
						}
						if("foodName".equals(option)){
							food.setFoodName(new String(fileItem.getString().getBytes("ISO8859-1"),"UTF-8"));
						}
						if("price".equals(option)){
							food.setPrice(Long.parseLong(new String(fileItem.getString().getBytes("ISO8859-1"),"UTF-8")));
						}
						if("vipPrice".equals(option)){
							food.setVipPrice(Long.parseLong(new String(fileItem.getString().getBytes("ISO8859-1"),"UTF-8")));
						}
						if("text".equals(option)){
							food.setText(new String(fileItem.getString().getBytes("ISO8859-1"),"UTF-8"));
						}
					}
					if(!fileItem.isFormField()){
						//是文件体
						String name = fileItem.getName();
						name=UUID.randomUUID().toString().replace("-", "")+"#"+name.substring(name.lastIndexOf("\\")+1, name.length());
						name=new String(name.getBytes("ISO8859-1"),"UTF-8"); 
						food.setImagePath(name);
						 //将文件上传
						fileItem.write(new File(getServletContext().getRealPath("/upload"),name));
						//关闭资源
						fileItem.delete();
					}
				}
			
		}
		return food;
	}

}
