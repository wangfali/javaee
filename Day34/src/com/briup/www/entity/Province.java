package com.briup.www.entity;

import java.util.List;

/**
 * 省份
 * @author wangfali
 *@version 1.0
 *@date 2017年3月12日
 */
public class Province {
	private Integer id;
	private String name;
	private List<City>citys;
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
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	public Province(Integer id, String name, List<City> citys) {
		this.id = id;
		this.name = name;
		this.citys = citys;
	}
	public Province() {
		super();
	}
	
}
