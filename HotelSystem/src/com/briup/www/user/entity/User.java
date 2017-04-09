package com.briup.www.user.entity;

import java.io.Serializable;

/**  
 * @ClassName: User  
 * @Description: 用户实体类  
 * @author wangfali
 * @date 2017年4月7日  
 * @version V1.0  
 */
public class User implements Serializable{  
	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private String password;
	private String imagePath;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public User(String id, String userName, String password, String imagePath) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.imagePath = imagePath;
	}
	
	
}
