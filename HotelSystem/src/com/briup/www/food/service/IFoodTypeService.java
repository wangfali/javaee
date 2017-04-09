package com.briup.www.food.service;

import java.util.List;
import java.util.Map;

import com.briup.www.food.entity.FoodType;
import com.briup.www.food.entity.PageBean;
/**  
 * @ClassName: IFoodTypeService  
 * @Description: 菜系业务层接口  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public interface IFoodTypeService {
	/**
	 * 
	* @Title: delete  
	* @Description: 通过id删除菜系  
	* @param @param id
	* @param @throws Exception 
	* @return void  
	* @throws
	 */
	 void delete(String id);
	 /**
	  * 
	 * @Title: save  
	 * @Description: 保存菜系  
	 * @param @param foodType
	 * @param @throws TypeNameExistException
	 * @param @throws Exception 
	 * @return void  
	 * @throws
	  */
	 void save(FoodType foodType);
	 /**
	  * 
	 * @Title: update  
	 * @Description: 更新菜系  
	 * @param @param foodType
	 * @param @throws Exception 
	 * @return void  
	 * @throws
	  */
	 void update(FoodType foodType);
	 /**
	  * 
	 * @Title: FindAll  
	 * @Description: 显示所有的菜系  
	 * @param @return
	 * @param @throws Exception 
	 * @return List<FoodType>  
	 * @throws
	  */
	 List<FoodType>FindAll();
	 /**
	  * 
	 * @Title: FindByid  
	 * @Description:通过id查找菜系  
	 * @param @param id
	 * @param @return 
	 * @return FoodType  
	 * @throws
	  */
	 FoodType FindByid(String id);
	 /**
	  * 
	 * @Title: FindAll  
	 * @Description: 根据名称查询菜系   
	 * @param @param typename
	 * @param @return
	 * @param @throws Exception 
	 * @return List<FoodType>  
	 * @throws
	  */
	 List<FoodType>FindAll(String typename);
	 /**
	  * 
	 * @Title: getAll  
	 * @Description: 分页查询菜系 
	 * @param @param pageBean 
	 * @return void  
	 * @throws
	  */
	 void getAll(PageBean<FoodType>pageBean);
	 /**
		 * 
		* @Title: getAnalyse  
		* @Description: 获取返回数据分析  
		* @param @return 
		* @return List<String>  
		* @throws
		 */
		public List<Map<String, String>> getAnalyse();
}
