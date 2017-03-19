package com.briup.www.service.impl;

import java.util.List;

import com.briup.www.dao.Impl.ImplFoodDao;
import com.briup.www.entity.Food;
import com.briup.www.entity.PageBean;
import com.briup.www.exception.TypeNameExistException;
import com.briup.www.service.IFoodService;

/**
 * 实现业务层菜品管理接口
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
public class ImplFoodService implements IFoodService{

	@Override
	public void delete(long id) throws Exception {
		new ImplFoodDao().delete(id);
		
	}

	@Override
	public void save(Food food) throws Exception {
		if(new ImplFoodDao().FindAll(food.getFoodName()).isEmpty()){
			new ImplFoodDao().save(food);
		}else{
			throw new TypeNameExistException("该菜品已经存在！");
		}
		
	}

	@Override
	public void update(Food food) throws Exception {
		new ImplFoodDao().update(food);
		
	}

	@Override
	public List<Food> FindAll() throws Exception {
		List<Food> list = new ImplFoodDao().FindAll();
		return list;
	}

	@Override
	public Food FindByid(long id) throws Exception {
		Food food = new ImplFoodDao().FindByid(id);
		return food;
	}

	@Override
	public List<Food> FindAll(String foodName) throws Exception {
		List<Food> list = new ImplFoodDao().FindAll(foodName);
		return list;
	}

	@Override
	public void getAll(PageBean<Food> pageBean) throws Exception {
		new ImplFoodDao().getAll(pageBean);
		
	}

}
