package com.briup.www.user.dao;

import java.util.List;

import com.briup.www.core.dao.IBaseDao;
import com.briup.www.user.entity.User;

/**  
 * @ClassName: IUserDao  
 * @Description: TODO  
 * @author wangfali
 * @date 2017年4月7日  
 * @version V1.0  
 */
public interface IUserDao extends IBaseDao<User>{
	/**
	 * 
	* @Title: findUser  
	* @Description: 通过用户名和密码查询用户是否存在  
	* @param @param userName
	* @param @param password
	* @param @return 
	* @return boolean  
	* @throws
	 */
	boolean findUser(String userName,String password);
	/**
	 
	* @Title: findByName  
	* @Description: 通过用户名查找  
	* @param @param userName
	* @param @return 
	* @return User  
	* @throws
	 */
	List<User> findByName(String userName);
}
