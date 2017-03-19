package com.briup.www.entity;
/**
 * 菜系的实体类
 * @author wangfali
 *@version 1.0
 *@date 2016年12月12日
 */
public class FoodType {
	private int  id;
	private String typeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public FoodType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	public FoodType() {
		super();
	}
	@Override
	public String toString() {
		return "FoodType [id=" + id + ", typeName=" + typeName + "]";
	}
}
