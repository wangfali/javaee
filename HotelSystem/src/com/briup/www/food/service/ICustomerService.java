package com.briup.www.food.service;

import java.io.Serializable;
import java.util.List;

import com.briup.www.food.entity.Customer;

/**  
 * @ClassName: ICustomerService  
 * @Description: 订单操作业务层接口  
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public interface ICustomerService {
	/**
	 * 
	* @Title: save  
	* @Description: 保存订单  
	* @param @param customer 
	* @return void  
	* @throws
	 */
	public void save(Customer customer);
	/**
	 * 
	* @Title: delete  
	* @Description: 删除订单  
	* @param @param id 
	* @return void  
	* @throws
	 */
	public void delete(Serializable id);
	/**
	 * 
	* @Title: getAll  
	* @Description: 查找所有的订单  
	* @param @return 
	* @return List<Customer>  
	* @throws
	 */
	public List<Customer>getAll();
	/**
	 * 
	* @Title: update  
	* @Description: 更新订单 
	* @param @param customer 
	* @return void  
	* @throws
	 */
	public void update(Customer customer);
}
