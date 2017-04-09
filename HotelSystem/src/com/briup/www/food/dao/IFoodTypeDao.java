package com.briup.www.food.dao;

import java.util.List;

import com.briup.www.core.dao.IBaseDao;
import com.briup.www.food.entity.FoodType;
import com.briup.www.food.entity.PageBean;

/**  
 * @ClassName: IFoodTypeDao  
 * @Description: 菜品数据操作接口  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public interface IFoodTypeDao extends IBaseDao<FoodType>{
	/**
	 * 
	* @Title: findAllName  
	* @Description: 查找所有的菜系名称  
	* @param @return 
	* @return List<String>  
	* @throws
	 */
	public List<String> findAllName();
	/**
	 * 
	* @Title: findAll  
	* @Description: 通过名称查询所有的菜系  
	* @param @param typename
	* @param @return 
	* @return List<FoodType>  
	* @throws
	 */
	public List<FoodType>findAll(String typename);
	 /**
	  * 
	 * @Title: getAll  
	 * @Description: 分页查询 
	 * @param @param pageBean 
	 * @return void  
	 * @throws
	  */
	 void getAll(PageBean<FoodType> pageBean);
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
		* @Title: getAnalyse  
		* @Description: 获取返回数据分析  
		* @param @return 
		* @return List<String>  
		* @throws
		 */
		public List<Object[]> getAnalyse();
}
