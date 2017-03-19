package com.briup.www.entity;
/**
 * 菜品的实体类
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
public class Food {
	private long id;
	private String foodName;
	private String foodType;
	private double price;
	private double vipPrice;
	private String text;
	private  String imagePath;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodName=" + foodName + ", foodType="
				+ foodType + ", price=" + price + ", vipPrice=" + vipPrice
				+ ", text=" + text + ", imagePath=" + imagePath + "]";
	}
	public Food(long id, String foodName, String foodType, double price,
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
