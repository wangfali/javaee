package com.briup.www.entity;
/**
 * 城市
 * @author wangfali
 *@version 1.0
 *@date 2017年3月12日
 */
public class City {
	private Integer id;
	private String name;
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
	public City(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public City() {
		super();
	}
	
}
