package com.briup.www.service.impl;

import java.util.List;

import com.briup.www.dao.Impl.FoodTypeDao;
import com.briup.www.entity.FoodType;
import com.briup.www.exception.TypeNameExistException;
import com.briup.www.service.IFoodTypeService;

/**
 * 实现业务层的接口
 * @author wangfali
 *@version 1.0
 *@date 2016年12月12日
 */
public class ImplFoodTypeService implements IFoodTypeService{

	@Override
	public void delete(int id) throws Exception {
		new FoodTypeDao().delete(id);
	}

	@Override
	public void save(FoodType foodType) throws Exception {
		//判断是否为重复添加
		if(FindAll(foodType.getTypeName()).isEmpty()){
			try {
				new FoodTypeDao().save(foodType);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			throw new TypeNameExistException("该菜系名已经存在!");
		}
		
	}

	@Override
	public void update(FoodType foodType) throws Exception {
		new FoodTypeDao().update(foodType);
		
	}

	@Override
	public List<FoodType> FindAll() throws Exception {
		return new FoodTypeDao().FindAll();
		
	}

	@Override
	public FoodType FindByid(int id) {
		
		return null;
	}
	@Override
	public List<FoodType> FindAll(String typename) throws Exception {
		return new FoodTypeDao().FindAll(typename);
	}
	
}
