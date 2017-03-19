package com.briup.www.entity;


/**
 * 封装城市和省份的类
 * @author wangfali
 *@version 1.0
 *@date 2017年3月12日
 */
public class Bean {
	private String province;
	private String city;
	private String section;
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Bean() {
	}
	
}
