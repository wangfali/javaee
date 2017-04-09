package com.briup.www.food.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.briup.www.core.dao.impl.ImplBaseDao;
import com.briup.www.food.dao.IFoodDao;
import com.briup.www.food.entity.Food;
import com.briup.www.food.entity.PageBean;

/**  
 * @ClassName: ImplFoodDao  
 * @Description: 实现菜品数据操作接口 
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class ImplFoodDao extends ImplBaseDao<Food> implements IFoodDao {

	/*  
	* <p>Title: findAll</p>  
	* <p>Description: 通过名称查询所有的菜品</p>  
	* @param name
	* @return  
	* @see com.briup.www.food.dao.IFoodDao#findAll(java.lang.String)  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Food> findAll(String name) {
		Query query = currentSession().createQuery("from Food where foodName=?");
		query.setString(0,name);
		return query.list();
	}

	/*  
	* <p>Title: getAll</p>  
	* <p>Description:分页查询</p>  
	* @param pageBean  
	* @see com.briup.www.food.dao.IFoodDao#getAll(com.briup.www.food.entity.PageBean)  
	*/
	@Override
	public void getAll(PageBean<Food> pageBean) {
		//获取总的记录数
		pageBean.setAllPageColum(getAllPageColum());
		//获取当前页
		long currentPage = pageBean.getCurrentPage();
		//获取第一页的行数
		long count = pageBean.getPageCount();
		//进行查询
		SQLQuery query = currentSession().createSQLQuery("select * from food limit ?,?");
		query.setParameter(0, (currentPage-1)*count);
		query.setParameter(1, count);
		query.addEntity(Food.class);
		@SuppressWarnings("unchecked")
		List<Food> list = query.list();
		pageBean.setPageList(list);
		
	}

	/*  
	* <p>Title: getAllPageColum</p>  
	* <p>Description:查询总记录数</p>  
	* @return  
	* @see com.briup.www.food.dao.IFoodDao#getAllPageColum()  
	*/
	@Override
	public long getAllPageColum() {
		SQLQuery query = currentSession().createSQLQuery("select count(*) from food");
		Number count = (Number)query.uniqueResult();
		count.longValue();
		return count.longValue();
	}

	/*  
	* <p>Title: findByFoodType</p>  
	* <p>Description:通过菜系名称查找相应的菜品</p>  
	* @param foodTypeName
	* @return  
	* @see com.briup.www.food.dao.IFoodDao#findByFoodType(java.lang.String)  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Food> findByFoodType(String foodTypeName) {
		SQLQuery query = currentSession().createSQLQuery("select * from food where foodType="+foodTypeName+"").addEntity(Food.class);
		return query.list();
	}

	
}
