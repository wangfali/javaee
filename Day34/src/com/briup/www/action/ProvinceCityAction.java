package com.briup.www.action;

import java.util.ArrayList;
import java.util.List;



import com.briup.www.entity.Bean;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 使用json实现三级联动
 * @author wangfali
 *@version 1.0
 *@date 2017年3月12日
 */
public class ProvinceCityAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//创建封装了省份和城市的对象
	private Bean bean;
	private List<String> citys;
	private List<String>sections;
	public void setBean(Bean bean) {
		this.bean = bean;
	}
	public Bean getBean() {
		return bean;
	}
	public List<String> getCitys() {
		return citys;
	}
	public List<String> getSections() {
		return sections;
	}
	public String city() throws Exception {
		//获取传输过来的省份值，创建一个集合
		String province=bean.getProvince();
		citys=new ArrayList<String>();
		//判断省份然后进行城市数据
		if("海南".equals(province)){
			citys.add("定安");
			citys.add("文昌");
			citys.add("海口");
			citys.add("琼海");
		}else if ("广东".equals(province)) {
			citys.add("湛江");
			citys.add("深圳");
			citys.add("珠海");
			citys.add("佛山");
		}
		return SUCCESS;
	}
	public String section()throws Exception{
		String city=bean.getCity();
		sections=new ArrayList<String>();
		//获取传输过来的城市值并判断
		if("定安".equals(city)){
			sections.add("塔岭");
			sections.add("仙沟");
			sections.add("老城");
		}else if("文昌".equals(city)){
			sections.add("文昌塔岭");
			sections.add("文昌仙沟");
			sections.add("文昌老城");
		}else if("海口".equals(city)){
			sections.add("海口塔岭");
			sections.add("海口仙沟");
			sections.add("海口老城");
		}else if("琼海".equals(city)){
			sections.add("琼海塔岭");
			sections.add("琼海仙沟");
			sections.add("琼海老城");
		}
		return SUCCESS;
	}
}
