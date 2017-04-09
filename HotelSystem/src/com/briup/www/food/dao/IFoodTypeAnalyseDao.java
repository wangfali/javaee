package com.briup.www.food.dao;

import java.util.List;

/**  
 * @ClassName: IFoodTypeAnalyseDao  
 * @Description: 分析菜系比重  
 * @author wangfali
 * @date 2017年4月2日  
 * @version V1.0  
 */
public interface IFoodTypeAnalyseDao{
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
