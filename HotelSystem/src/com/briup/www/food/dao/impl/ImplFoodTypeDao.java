package com.briup.www.food.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.briup.www.core.dao.impl.ImplBaseDao;
import com.briup.www.food.dao.IFoodTypeDao;
import com.briup.www.food.entity.FoodType;
import com.briup.www.food.entity.PageBean;

/**  
 * @ClassName: ImplFoodTypeDao  
 * @Description: 实现菜品数据操作接口  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class ImplFoodTypeDao extends ImplBaseDao<FoodType> implements IFoodTypeDao{

	/*  
	* <p>Title: findAllName</p>  
	* <p>Description:查询所有菜系的名称 </p>  
	* @return  
	* @see com.briup.www.food.dao.IFoodTypeDao#findAllName()  
	*/
	@Override
	public List<String> findAllName() {
		SQLQuery query = currentSession().createSQLQuery("select typeName from foodtype");
		@SuppressWarnings( "unchecked" )
		List<String> list =(List<String>) query.list();
		return list;
	}

	/*  
	* <p>Title: findAll</p>  
	* <p>Description: 通过名称查询所有的菜系</p>  
	* @param typename
	* @return  
	* @see com.briup.www.food.dao.IFoodTypeDao#findAll(java.lang.String)  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<FoodType> findAll(String typename) {
		Query query = currentSession().createQuery("from FoodType where typeName=?");
		query.setString(0,typename);
		return query.list();
	}

	/*  
	* <p>Title: getAll</p>  
	* <p>Description:分页查询</p>  
	* @param pageBean  
	* @see com.briup.www.food.dao.IFoodTypeDao#getAll(com.briup.www.food.entity.PageBean)  
	*/
	@Override
	public void getAll(PageBean<FoodType> pageBean) {
		//获取总的记录数
				pageBean.setAllPageColum(getAllPageColum());
				//获取当前页
				long currentPage = pageBean.getCurrentPage();
				//获取第一页的行数
				long count = pageBean.getPageCount();
				//进行查询
				SQLQuery query = currentSession().createSQLQuery("select * from foodtype limit ?,?");
				query.setParameter(0, (currentPage-1)*count);
				query.setParameter(1, count);
				query.addEntity(FoodType.class);
				@SuppressWarnings("unchecked")
				List<FoodType> list = query.list();
				pageBean.setPageList(list);
	}

	/*  
	* <p>Title: getAllPageColum</p>  
	* <p>Description:查询总记录数</p>  
	* @return  
	* @see com.briup.www.food.dao.IFoodTypeDao#getAllPageColum()  
	*/
	@Override
	public long getAllPageColum() {
		SQLQuery query = currentSession().createSQLQuery("select count(*) from foodtype");
		Number count = (Number)query.uniqueResult();
		count.longValue();
		return count.longValue();
	}

	/*  
	* <p>Title: getAnalyse</p>  
	* <p>Description:获取返回数据分析</p>  
	* @return  
	* @see com.briup.www.food.dao.IFoodTypeDao#getAnalyse()  
	*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAnalyse() {
		SQLQuery query = currentSession().createSQLQuery("SELECT foodType as label, COUNT(id) as value FROM food GROUP BY foodType ORDER BY foodName");
		List<Object[]> list = query.list();
		return list;
	}
}
