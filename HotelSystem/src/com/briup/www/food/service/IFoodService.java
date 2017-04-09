package com.briup.www.food.service;

import java.io.Serializable;
import java.util.List;

import com.briup.www.food.entity.Food;
import com.briup.www.food.entity.PageBean;



/**  
 * @ClassName: IFoodService  
 * @Description: 菜品业务层接口   
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public interface IFoodService {
	/**
	 * 
	* @Title: delete  
	* @Description: 通过id删除菜品
	* @param @param id
	* @param @throws Exception 
	* @return void  
	* @throws
	 */
	 void delete(String id);
	 /**
	  * 
	 * @Title: save  
	 * @Description: 保存菜品  
	 * @param @param food
	 * @param @throws Exception 
	 * @return void  
	 * @throws
	  */
	 void save(Food food);
	 /**
	  * 
	 * @Title: update  
	 * @Description: 更新菜品  
	 * @param @param food
	 * @param @throws Exception 
	 * @return void  
	 * @throws
	  */
	 void update(Food food);
	 /**
	  * 
	 * @Title: FindAll  
	 * @Description: 显示所有的菜品  
	 * @param @return
	 * @param @throws Exception 
	 * @return List<Food>  
	 * @throws
	  */
	 List<Food>FindAll();
	 /**
	  * 
	 * @Title: FindByid  
	 * @Description: 通过id查找菜品  
	 * @param @param id
	 * @param @return
	 * @param @throws Exception 
	 * @return Food  
	 * @throws
	  */
	 Food FindByid(Serializable id);
	 /**
	  * 
	 * @Title: FindAll  
	 * @Description:根据名称查询菜品  
	 * @param @param foodName
	 * @param @return
	 * @param @throws Exception 
	 * @return List<Food>  
	 * @throws
	  */
	 List<Food>FindAll(String foodName);
	 /**
	  * 
	 * @Title: getAll  
	 * @Description: 获取分页数据  
	 * @param @param pageBean
	 * @param @throws Exception 
	 * @return void  
	 * @throws
	  */
	 void getAll(PageBean<Food>pageBean);
	 /**
	  * 
	 * @Title: findFoodTypeName  
	 * @Description: 查询所有菜系名称  
	 * @param @return 
	 * @return List<String>  
	 * @throws
	  */
	 List<String> findFoodTypeName();
	 /**
	  * 
	 * @Title: findByFoodTypeName  
	 * @Description: 通过菜系名称进行查找菜品  
	 * @param @param foodTypeName
	 * @param @return 
	 * @return List<Food>  
	 * @throws
	  */
	 List<Food>findByFoodTypeName(String foodTypeName);
	
	
}
