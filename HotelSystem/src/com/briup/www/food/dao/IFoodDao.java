package com.briup.www.food.dao;

import java.util.List;

import com.briup.www.core.dao.IBaseDao;
import com.briup.www.food.entity.Food;
import com.briup.www.food.entity.PageBean;


/**  
 * @ClassName: IFoodDao  
 * @Description: 菜品管理的数据操作  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public interface IFoodDao extends IBaseDao<Food>{
	/**
	 * 
	* @Title: findAll  
	* @Description: 通过名称查询所有的数据 
	* @param @param name
	* @param @return 
	* @return List<Food>  
	* @throws
	 */
	public List<Food>findAll(String name);
	 /**
	  * 
	 * @Title: getAll  
	 * @Description: 分页查询 
	 * @param @param pageBean 
	 * @return void  
	 * @throws
	  */
	 void getAll(PageBean<Food> pageBean);
	 /**
	  * 
	 * @Title: getAllPageColum  
	 * @Description: 查询总的记录数  
	 * @param @return 
	 * @return long  
	 * @throws
	  */
	 long getAllPageColum();
	 /**
	  * 
	 * @Title: findByFoodType  
	 * @Description: 通过菜系名称查找相应的菜品 
	 * @param @param foodTypeName
	 * @param @return 
	 * @return List<Food>  
	 * @throws
	  */
	 List<Food>findByFoodType(String foodTypeName);
}
