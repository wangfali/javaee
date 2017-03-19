package com.briup.www.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.briup.www.dao.IFoodDao;
import com.briup.www.dao.Impl.ImplFoodDao;
import com.briup.www.entity.Food;
import com.briup.www.entity.PageBean;

/**
 * 测试菜品数据操作
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
public class TestFoodDao {
	IFoodDao operate;
	@Before
	public void init(){
		operate=new ImplFoodDao();
	}
	@Test
	public void test1() throws Exception{
		operate.save(new Food(1, "1", "1", 32.1, 12.1,new String("你好！"),new String("你好")));
	}
	@Test
	public void test2() throws Exception{
		List<Food> findAll = operate.FindAll();
		System.out.println(findAll);
	}
	@Test
	public void test3() throws Exception{
	 Food food = operate.FindByid(3);
		System.out.println(food);
	}
	@Test
	public void test4() throws Exception{
		 List<Food> findAll = operate.FindAll("%");
		System.out.println(findAll);
	}
	@Test
	public void test5() throws Exception{
		operate.update(new Food(1, "wang", "wang", 23.3, 32.4,"wang","wang"));
	}
	@Test
	public void test6() throws Exception{
		operate.delete(3);
	}
	@Test
	public void test7() throws Exception{
		operate.getAll(new PageBean<Food>());
	}
}
