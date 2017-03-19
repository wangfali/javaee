package com.briup.www.service;

import java.util.List;

import com.briup.www.entity.FoodType;
import com.briup.www.exception.TypeNameExistException;

/**
 * 菜系操作的业务逻辑层
 * @author wangfali
 *@version 1.0
 *@date 2016年12月12日
 */
public interface IFoodTypeService {
		/**
		 * 通过id删除菜系
		 *@return void
		 *@param @param id
		 * @throws Exception 
		 *
		 */
		 void delete(int id) throws Exception;
		 /**
		  * 保存菜系
		  *@return void
		  *@param @param foodType
		 * @throws TypeNameExistException 
		 * @throws Exception 
		  *
		  */
		 void save(FoodType foodType) throws TypeNameExistException, Exception;
		 /**
		  * 更新菜系
		  *@return void
		  *@param @param foodType
		 * @throws Exception 
		  *
		  */
		 void update(FoodType foodType) throws Exception;
		 /**
		  * 显示所有的菜系
		  *@return List<FoodType>
		  *@param @return
		 * @throws Exception 
		  *
		  */
		 List<FoodType>FindAll() throws Exception;
		 /**
		  * 通过id查找菜系
		  *@return FoodType
		  *@param @param id
		  *@param @return
		  *
		  */
		 FoodType FindByid(int id);
		 /**
		  *根据名称查询菜系 
		 * @throws Exception 
		  */
		 List<FoodType>FindAll(String typename) throws Exception;
		 
	}