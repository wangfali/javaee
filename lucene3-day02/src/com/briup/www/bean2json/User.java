package com.briup.www.bean2json;
/**
 * 
* @ClassName: User
* @Description: 将javabean类转换为json
* @author wangfali
* @date 2017年5月27日 下午10:10:40
*
 */
public class User {
	private Integer id;//编号
	private String name;//姓名
	private Integer sal;//薪水
	private String gender;//性别
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public User(Integer id, String name, Integer sal, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.gender = gender;
	}
	public User() {
		super();
	}
	
	
	
}
