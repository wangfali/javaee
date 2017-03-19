package com.briup.www.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.briup.www.dao.IFoodTypeDao;
import com.briup.www.dao.Impl.FoodTypeDao;
import com.briup.www.entity.FoodType;

/**
 * 测试数据库连接
 * @author wangfali
 *@version 1.0
 *@date 2016年12月15日
 */
public class TestDao {
	IFoodTypeDao operate;
	@Before
	public void init(){
		operate=new FoodTypeDao();
	}
	@Test
	public void test1() throws Exception{
		operate.save(new FoodType(12,"jiand"));
	}
	@Test
	public void test2() throws Exception{
		List<FoodType> findAll = operate.FindAll();
		System.out.println(findAll);
	}
	@Test
	public void test3() throws Exception{
		FoodType foodType = operate.FindByid(2);
		System.out.println(foodType);
	}
	@Test
	public void test4() throws Exception{
		List<FoodType> findAll = operate.FindAll("j%");
		System.out.println(findAll);
	}
	@Test
	public void test5() throws Exception{
		operate.update(new FoodType(2,"wangfali"));
	}
	@Test
	public void test6() throws Exception{
		operate.delete(1);
	}
}
