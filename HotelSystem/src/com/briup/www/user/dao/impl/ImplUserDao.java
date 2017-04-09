package com.briup.www.user.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import com.briup.www.core.dao.impl.ImplBaseDao;
import com.briup.www.user.dao.IUserDao;
import com.briup.www.user.entity.User;

/**  
 * @ClassName: ImplUserDao  
 * @Description: TODO  
 * @author wangfali
 * @date 2017年4月7日  
 * @version V1.0  
 */
public class ImplUserDao extends ImplBaseDao<User> implements IUserDao{

	/*  
	* <p>Title: findUser</p>  
	* <p>Description: </p>  
	* @param userName
	* @param password
	* @return  
	* @see com.briup.www.user.dao.IUserDao#findUser(java.lang.String, java.lang.String)  
	*/
	@Override
	public boolean findUser(String userName, String password) {
		SQLQuery query = currentSession().createSQLQuery("select * from user where userName=? and password=?");
		query.setParameter(0, userName);
		query.setParameter(1, password);
		query.addEntity(User.class);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}

	/*  
	* <p>Title: findByName</p>  
	* <p>Description:通过用户名查找</p>  
	* @param userName
	* @return  
	* @see com.briup.www.user.dao.IUserDao#findByName(java.lang.String)  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByName(String userName) {
		SQLQuery query = currentSession().createSQLQuery("select * from user where userName=?").addEntity(User.class);
		query.setParameter(0, userName);
		return query.list();
	}

}
