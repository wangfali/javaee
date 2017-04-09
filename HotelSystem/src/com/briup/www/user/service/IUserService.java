/**    
* @Title: IUserService.java  
* @Package com.briup.www.user.service  
* @Description: TODO  
* @author wangfali    
* @date 2017年4月7日 下午10:04:42  
* @version V1.0    
*/
package com.briup.www.user.service;

import java.io.Serializable;
import java.util.List;

import com.briup.www.user.entity.User;

/**  
 * @ClassName: IUserService  
 * @Description: TODO  
 * @author wangfali
 * @date 2017年4月7日  
 * @version V1.0  
 */
public interface IUserService {
	/**
	 * 
	* @Title: findAll  
	* @Description: 获取所有的用户信息 
	* @param @return 
	* @return List<User>  
	* @throws
	 */
	public List<User>findAll();
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
	 * 
	* @Title: findsByName  
	* @Description: 通过用户名进行查找  
	* @param @param userName
	* @param @return 
	* @return List<User>  
	* @throws
	 */
	List<User>findsByName(String userName);
	/**
	 * 
	* @Title: save  
	* @Description: 保存用户  
	* @param @param user 
	* @return void  
	* @throws
	 */
	void save(User user);
	/**
	 * 
	* @Title: delete  
	* @Description: 删除用户 
	* @param @param user 
	* @return void  
	* @throws
	 */
	void delete(Serializable id);
	/**
	 * 
	* @Title: update  
	* @Description: 更新用户 
	* @param @param user 
	* @return void  
	* @throws
	 */
	void update(User user);
	/**
	 * 
	* @Title: findById  
	* @Description: 通过主键查询  
	* @param @param id
	* @param @return 
	* @return User  
	* @throws
	 */
	User findById(Serializable id);
}
