package com.briup.www.bean2json;
/**
 * 
* @ClassName: Testjson
* @Description: 使用第三方工具将javabean，list,map集合转换为json格式
* @author wangfali
* @date 2017年5月27日 下午10:14:20
*
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONArray;

public class Testjson {
	
	public void javabean2json()throws Exception{
		User user = new User(1,"wangfali", 2000, "男");
		JSONArray jsonArray = JSONArray.fromObject(user);
		String json = jsonArray.toString();
		System.out.println(json);
	}
	
	public void list2json()throws Exception{
		List<User>users=new ArrayList<User>();
		users.add(new User(1, "王法立", 10000, "nan"));
		users.add(new User(2, "王法", 2111, "an"));
		users.add(new User(3,"wangfa",3221,"anad"));
		JSONArray fromObject = JSONArray.fromObject(users);
		System.out.println(fromObject.toString());
	}
	@Test
	public void map2json()throws Exception{
		Map<String, User>users=new HashMap<String,User>();
		users.put("1", new User(1, "person", 1000, "ann"));
		users.put("2", new User(2, "adada", 23231, "ffdsfds"));
		users.put("3", new User(3, "fafds", 32432, "eda"));
		JSONArray fromObject = JSONArray.fromObject(users);
		System.out.println(fromObject.toString());
	}
}
