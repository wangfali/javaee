package com.briup.www.food.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**  
 * @ClassName: Income  
 * @Description: 酒店年度总收入  
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public class Income implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private BigDecimal money;
	private String month;
	private String year;
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Income(String id, BigDecimal money, String month, String year) {
		super();
		this.id = id;
		this.money = money;
		this.month = month;
		this.year = year;
	}
	public Income() {
		super();
	}
	
	
}
