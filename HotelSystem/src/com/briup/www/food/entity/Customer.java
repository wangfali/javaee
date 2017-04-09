package com.briup.www.food.entity;

import java.io.Serializable;
import java.util.Date;

/**  
 * @ClassName: Customer  
 * @Description: 顾客订单管理 
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String boardName;
	private double price;
	private Date time;
	private boolean state;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Customer(String id, String boardName, double price, Date time,
			boolean state) {
		super();
		this.id = id;
		this.boardName = boardName;
		this.price = price;
		this.time = time;
		this.state = state;
	}
	public Customer() {
		super();
	}
	

}
