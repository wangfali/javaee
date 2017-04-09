/**    
* @Title: ImplUserService.java  
* @Package com.briup.www.user.service.impl  
* @Description: TODO  
* @author wangfali    
* @date 2017年4月7日 下午10:12:58  
* @version V1.0    
*/
package com.briup.www.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.briup.www.user.dao.IUserDao;
import com.briup.www.user.entity.User;
import com.briup.www.user.service.IUserService;

/**  
 * @ClassName: ImplUserService  
 * @Description: TODO  
 * @author wangfali
 * @date 2017年4月7日  
 * @version V1.0  
 */
public class ImplUserService implements IUserService{
	@Resource
	private IUserDao iUserDao;
	/*  
	* <p>Title: findAll</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.briup.www.user.service.IUserService#findAll()  
	*/
	@Override
	public List<User> findAll() {
		return iUserDao.findObjects();
	}

	/*  
	* <p>Title: findUser</p>  
	* <p>Description: </p>  
	* @param userName
	* @param password
	* @return  
	* @see com.briup.www.user.service.IUserService#findUser(java.lang.String, java.lang.String)  
	*/
	@Override
	public boolean findUser(String userName, String password) {
		return iUserDao.findUser(userName, password);
	}

	/*  
	* <p>Title: findsByName</p>  
	* <p>Description:通过用户名进行</p>  
	* @param userName
	* @return  
	* @see com.briup.www.user.service.IUserService#findsByName(java.lang.String)  
	*/
	@Override
	public List<User> findsByName(String userName) {
		return iUserDao.findByName(userName);
	}

	/*  
	* <p>Title: save</p>  
	* <p>Description:保存用户</p>  
	* @param user  
	* @see com.briup.www.user.service.IUserService#save(com.briup.www.user.entity.User)  
	*/
	@Override
	public void save(User user) {
		iUserDao.save(user);
	}

	/*  
	* <p>Title: delete</p>  
	* <p>Description:删除用户</p>  
	* @param user  
	* @see com.briup.www.user.service.IUserService#delete(com.briup.www.user.entity.User)  
	*/
	@Override
	public void delete(Serializable id) {
		iUserDao.delete(id);
	}

	/*  
	* <p>Title: update</p>  
	* <p>Description: </p>  
	* @param user  
	* @see com.briup.www.user.service.IUserService#update(com.briup.www.user.entity.User)  
	*/
	@Override
	public void update(User user) {
		iUserDao.update(user);
	}

	/*  
	* <p>Title: findById</p>  
	* <p>Description:通过主键查询</p>  
	* @param id
	* @return  
	* @see com.briup.www.user.service.IUserService#findById(java.io.Serializable)  
	*/
	@Override
	public User findById(Serializable id) {
		return iUserDao.findObjectById(id);
	}

}
