/**    
* @Title: ImplBaseDao.java  
* @Package com.briup.www.core.dao.impl  
* @Description: TODO  
* @author wangfali    
* @date 2017年3月27日 下午9:36:43  
* @version V1.0    
*/
package com.briup.www.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.briup.www.core.dao.IBaseDao;

/**  
 * @ClassName: ImplBaseDao  
 * @Description: TODO  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class ImplBaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {

	/**
	 * 维护一个当前类的字节码
	 */
	Class<T>clazz;
	/**
	 * 无参构造函数
	 */
	@SuppressWarnings("unchecked")
	public ImplBaseDao(){
		ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) type.getActualTypeArguments()[0];
	}
	/*  
	* <p>Title: save</p>  
	* <p>Description:调用bibernatetemplte中的方法实现接口中的方法 </p>  
	* @param t  
	* @see com.briup.www.dao.IBaseDao#save(java.lang.Object)  
	*/
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	/*  
	* <p>Title: delete</p>  
	* <p>Description:通过主键删除对象使用hibernatemplate方法</p>  
	* @param id  
	* @see com.briup.www.dao.IBaseDao#delete(java.io.Serializable)  
	*/
	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findObjectById(id));
	}

	/*  
	* <p>Title: update</p>  
	* <p>Description:对象的更新使用hibernatemplate中的方法 </p>  
	* @param t  
	* @see com.briup.www.dao.IBaseDao#update(java.lang.Object)  
	*/
	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	/*  
	* <p>Title: findObjectById</p>  
	* <p>Description:通过主键查询对象信息hibernatemplate中的方法 </p>  
	* @param id
	* @return  
	* @see com.briup.www.dao.IBaseDao#findObjectById(java.io.Serializable)  
	*/
	@Override
	public T findObjectById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/*  
	* <p>Title: findObjects</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.briup.www.dao.IBaseDao#findObjects()  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findObjects() {
		Query query = currentSession().createQuery("from "+clazz.getSimpleName());
		return query.list();
	}
}