/**    
 * @Title: UserAction.java  
 * @Package com.briup.www.user.action  
 * @Description: TODO  
 * @author wangfali    
 * @date 2017年4月7日 下午10:15:41  
 * @version V1.0    
 */
package com.briup.www.user.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.briup.www.user.entity.User;
import com.briup.www.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: UserAction
 * @Description: TODO
 * @author wangfali
 * @date 2017年4月7日
 * @version V1.0
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	@Resource
	private IUserService iUserService;
	private User user = new User();
	private List<User> userList;
	private File image;
	private String imageFileName;
	private String imageContentType;

	// 查找所有的用户
	public String userUI() throws Exception {
		userList = iUserService.findAll();
		return "userUI";
	}

	// 用户验证
	public String login() throws Exception {
		
		return SUCCESS;
	}

	// 用户ajax验证
	public void yanzheng() throws Exception {
		boolean b = iUserService.findUser(user.getUserName(),
				user.getPassword());
		if(b==true){
			//创建一个会话存储用户头像信息
			List<User> list = iUserService.findsByName(user.getUserName());
			User user2 = list.get(0);
			Map<String, Object>session= new HashMap<String, Object>();
			System.out.println(user2.getImagePath());
			session.put("imagePath", user2.getImagePath());
			ServletActionContext.getServletContext().setAttribute("imagePath", user2.getImagePath());
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		writer.write(Boolean.toString(b));
		writer.close();
	}

	// 验证添加用户
	public void verifyUserName() throws Exception {
		// 通过用户名查找用户是否存在
		List<User> list = iUserService.findsByName(user.getUserName());
		String result = "false";
		if (list != null && list.size() > 0) {
			result = "true";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.close();
	}
	//添加用户
	public String addUserUI()throws Exception{
		return "addUserUI";
	}
	// 确认添加用户
	public String addUser() throws Exception {
		// 获取保存图片路径
		String path = ServletActionContext.getServletContext().getRealPath(
				"upload/user");
		// 加工图片地址
		String filename = UUID.randomUUID().toString().replaceAll("-", "")
				+ imageFileName.substring(imageFileName.lastIndexOf("."));
		// 保存图片的真实地址到数据库当中
		user.setImagePath("user/"+filename);
		// 复制文件当文件夹当中
		FileUtils.copyFile(image, new File(path, filename));
		// 保存用户
		iUserService.save(user);
		return "list";
	}
	//删除用户
	public String delete() throws Exception{
		iUserService.delete(user.getId());
		return "list";
	}
	//更新用户
	public String updateUI()throws Exception{
		//查询用户，表单回显
		user= iUserService.findById(user.getId());
		return "updateUI";
	}
	//确认更新用户
	public String update()throws Exception{
		iUserService.update(user);
		return "list";
	}
	
	@Override
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

}
