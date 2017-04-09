package com.briup.www.food.entity;

import java.io.Serializable;

/**
 * @ClassName: Food
 * @Description: 菜品的实体类
 * @author wangfali
 * @date 2017年3月27日
 * @version V1.0
 */
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String foodName;
	private String foodType;
	private double price;
	private double vipPrice;
	private String text;
	private String imagePath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(double vipPrice) {
		this.vipPrice = vipPrice;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Food(String id, String foodName, String foodType, double price,
			double vipPrice, String text, String imagePath) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodType = foodType;
		this.price = price;
		this.vipPrice = vipPrice;
		this.text = text;
		this.imagePath = imagePath;
	}

	public Food() {
		super();
	}

}
