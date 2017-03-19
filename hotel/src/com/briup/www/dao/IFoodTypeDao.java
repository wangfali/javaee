package com.briup.www.dao;

import java.util.List;

import com.briup.www.entity.FoodType;

/**
 * 菜系实体类对对数据的操作接口
 * @author wangfali
 *@version 1.0
 *@date 2016年12月12日
 */
public interface IFoodTypeDao {
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
	 * @throws Exception 
	  *
	  */
	 void save(FoodType foodType) throws Exception;
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
	 * @throws Exception 
	  *
	  */
	 FoodType FindByid(int id) throws Exception;
	 /**
	  *根据名称查询菜系 
	 * @throws Exception 
	  */
	 List<FoodType>FindAll(String typename) throws Exception;
	 
}
