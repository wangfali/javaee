package com.briup.www.dao;

import java.util.List;

import com.briup.www.entity.Food;
import com.briup.www.entity.PageBean;

/**
 * 菜品管理的数据操作
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
public interface IFoodDao {
	/**
	 * 通过id删除菜品
	 *@return void
	 *@param @param id
	 * @throws Exception 
	 *
	 */
	 void delete(long id) throws Exception;
	 /**
	  * 保存菜品
	  *@return void
	  *@param @param Food
	 * @throws Exception 
	  *
	  */
	 void save(Food food) throws Exception;
	 /**
	  * 更新菜品
	  *@return void
	  *@param @param Food
	 * @throws Exception 
	  *
	  */
	 void update(Food food) throws Exception;
	 /**
	  * 显示所有的菜品
	  *@return List<FoodType>
	  *@param @return
	 * @throws Exception 
	  *
	  */
	 List<Food>FindAll() throws Exception;
	 /**
	  * 通过id查找菜品
	  *@return	Food
	  *@param @param id
	  *@param @return
	 * @throws Exception 
	  *
	  */
	 Food FindByid(long id) throws Exception;
	 /**
	  *根据名称查询菜品 
	 * @throws Exception 
	  */
	 List<Food>FindAll(String foodName) throws Exception;
	 /**
	  * 查询分页的数据
	  *@return void
	  *@param @param pageBean
	 * @throws Exception 
	  *
	  */
	 void getAll(PageBean<Food> pageBean) throws Exception;
	 /**
	  * 查询总的记录数
	  *@return long
	  *@param @return
	 * @throws Exception 
	  *
	  */
		long getAllPageColum() throws Exception; 
	
}
