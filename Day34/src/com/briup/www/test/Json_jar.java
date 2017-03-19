package com.briup.www.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import com.briup.www.entity.City;
import com.briup.www.entity.Province;

/**
 * 使用第三方插件，实现json的编译
 * @author wangfali
 *@version 1.0
 *@date 2017年3月12日
 */
public class Json_jar {
	//创建javabean对象
	private static void  javabean2json(){
		City city = new City(23, "海口");
		JSONArray object = JSONArray.fromObject(city);
		System.out.println(object.toString());	
	}
	private static void list2json(){
		List<City>citys=new ArrayList<City>();
		citys.add( new City(12, "hhiakou"));
		citys.add( new City(21, "定安"));
		JSONArray listArray = JSONArray.fromObject(citys);
		System.out.println(listArray.toString());
	}
	private static void set2json(){
		Set<City>citys=new LinkedHashSet<City>();
		citys.add( new City(12, "hhiakou"));
		citys.add( new City(21, "定安"));
		JSONArray listArray = JSONArray.fromObject(citys);
		System.out.println(listArray.toString());
	}
	private static void javabeanlist2json(){
		List<City>citys=new ArrayList<City>();
		citys.add( new City(12, "hhiakou"));
		citys.add( new City(21, "定安"));
		Province province = new Province(1, "bieji",citys);
		JSONArray listArray = JSONArray.fromObject(province);
		System.out.println(listArray.toString());
	}
	public static void map2json(){ 
		List<City>citys=new ArrayList<City>();
		citys.add( new City(12, "hhiakou"));
		citys.add( new City(21, "定安"));
		Map<String, Object>p=new HashMap<String, Object>();
		p.put("total", citys.size());
		p.put("rows", citys);
		JSONArray fromjson = JSONArray.fromObject(p);
		String str = fromjson.toString();
		str=str.substring(1, str.length()-1);
		System.out.println(str);
	}
	public static void main(String[] args) {
		//javabean2json();
		//list2json();
		//set2json();
		//javabeanlist2json();
		map2json();
	}
}
