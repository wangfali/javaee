package com.briup.www.food.entity;

import java.io.Serializable;

/**  
 * @ClassName: FoodType  
 * @Description: 菜系的实体类  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class FoodType implements Serializable{ 
	private static final long serialVersionUID = 1L;
	private String  id;
	private String typeName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public FoodType(String id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}
	public FoodType() {
	}
	
	
}
