package com.briup.www;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 省份和城市的两级联动
 * @author wangfali
 *@version 1.0
 *@date 2017年3月18日
 */
public class ProvinceAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String province;
	private List<String>citys;
	public String getProvince() {
		return province;
	}public void setProvince(String province) {
		this.province = province;
	}
	public List<String> getCitys() {
		return citys;
	}
	public void setCitys(List<String> citys) {
		this.citys = citys;
	}
	@Override
	public String execute() throws Exception {
		//创建集合空间
		citys=new ArrayList<String>();
		//获取省份名称，并判断
		if("海南".equals(province)){
			citys.add("定安");
			citys.add("翰林");
			citys.add("琼海");
		}if("湖南".equals(province)){
			citys.add("定安3");
			citys.add("翰林3");
			citys.add("琼海");
		}
		
		return SUCCESS;
	}
}
