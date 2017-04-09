
package com.briup.www.core.dao;

import java.io.Serializable;
import java.util.List;

/**  
 * @ClassName: IBaseDao  
 * @Description: 抽离出数据操作的公用方法，简化开发的接口  
 * @author wangfali
 * @date 2017年3月20日  
 * @version V1.0  
 */
	public interface IBaseDao<T> {
		/**
		 * 
		* @Title: save  
		* @Description: 保存方法  
		* @param  
		* @return void  
		* @throws
		 */
		public void save(T t);
		/**
		* @Title: delete  
		* @Description: 通过主键删除 
		* @param  id 
		* @return void  
		* @throws
		 */
		public void delete(Serializable id);
		/**
		* @Title: update  
		* @Description: 修改 
		* @param @param t 
		* @return void  
		* @throws
		 */
		public void update(T t);
		/**
		 * 
		* @Title: findObjectById  
		* @Description: 通过主键查找对象信息  
		* @param id 
		* @return T  
		* @throws
		 */
		public T findObjectById(Serializable id);
		/**
		* @Title: findObjects  
		* @Description: 查找出所有的对象 
		* @param  
		* @return List<T>  
		* @throws
		 */
		public List<T> findObjects();
}
