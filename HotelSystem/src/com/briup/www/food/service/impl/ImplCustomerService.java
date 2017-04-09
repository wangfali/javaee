package com.briup.www.food.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.briup.www.food.dao.ICustomerDao;
import com.briup.www.food.entity.Customer;
import com.briup.www.food.service.ICustomerService;

/**  
 * @ClassName: ImplCustomerService  
 * @Description: 实现订单业务层接口  
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public class ImplCustomerService implements ICustomerService{
	@Resource
	private ICustomerDao iCustomerDao;
	/*  
	* <p>Title: save</p>  
	* <p>Description:保存订单</p>  
	* @param customer  
	* @see com.briup.www.food.service.ICustomerService#save(com.briup.www.food.entity.Customer)  
	*/
	@Override
	public void save(Customer customer) {
		iCustomerDao.save(customer);
	}

	/*  
	* <p>Title: delete</p>  
	* <p>Description:删除订单</p>  
	* @param id  
	* @see com.briup.www.food.service.ICustomerService#delete(java.io.Serializable)  
	*/
	@Override
	public void delete(Serializable id) {
		iCustomerDao.delete(id);
	}

	/*  
	* <p>Title: getAll</p>  
	* <p>Description:返回所有订单</p>  
	* @return  
	* @see com.briup.www.food.service.ICustomerService#getAll()  
	*/
	@Override
	public List<Customer> getAll() {
		return iCustomerDao.findObjects();
	}

	/*  
	* <p>Title: update</p>  
	* <p>Description:更新订单</p>  
	* @param customer  
	* @see com.briup.www.food.service.ICustomerService#update(com.briup.www.food.entity.Customer)  
	*/
	@Override
	public void update(Customer customer) {
		iCustomerDao.update(customer);
	}

}
