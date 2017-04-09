package com.briup.www.food.service;

import java.util.List;
import java.util.Map;

import com.briup.www.food.entity.Income;

/**  
 * @ClassName: IIncomeService  
 * @Description: 年度收入总计  
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public interface IIncomeService {
	/**
	 * 
	* @Title: getSumary  
	* @Description: 获取年度收入总计  
	* @param @return 
	* @return List<Object[]>  
	* @throws
	 */
	public List<Map<String, String>> getSumary();
	/**
	 * 
	* @Title: getBoardSumary  
	* @Description: 获取年度订餐量  
	* @param @return 
	* @return List<Object[]>  
	* @throws
	 */
	public List<Map<String, String>> getBoardSumary();
	/**
	 * 
	* @Title: save  
	* @Description: 保存收入  
	* @param @param income 
	* @return void  
	* @throws
	 */
	public void save(Income income);
	/**
	 * 
	* @Title: getCustmer  
	* @Description: 获取年度客流量分析  
	* @param @return 
	* @return List<Map<String,String>>  
	* @throws
	 */
	public List<Map<String, String>>getCustmer();
}
