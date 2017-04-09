package com.briup.www.food.dao;

import java.util.List;

import com.briup.www.core.dao.IBaseDao;
import com.briup.www.food.entity.Income;

/**  
 * @ClassName: IIncomeDao  
 * @Description: 年度收入总计  
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public interface IIncomeDao extends IBaseDao<Income>{
	/**
	 * 
	* @Title: getSumary  
	* @Description: 获取年度总结数据  
	* @param @return 
	* @return List<Object[]>  
	* @throws
	 */
	public List<Object[]> getSumary();
	/**
	 * 
	* @Title: getBoardSumary  
	* @Description: 获取年度定餐量  
	* @param @return 
	* @return List<Object[]>  
	* @throws
	 */
	public List<Object[]> getBoardSumary();
	/**
	 * 
	* @Title: getCustmer  
	* @Description: 年度客流量分析 
	* @param @return 
	* @return List<Object[]>  
	* @throws
	 */
	public List<Object[]>getCustmer();
}
