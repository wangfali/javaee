package com.briup.www.food.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.briup.www.core.dao.impl.ImplBaseDao;
import com.briup.www.food.dao.IBoardDao;
import com.briup.www.food.entity.Board;
import com.briup.www.food.entity.PageBean;

/**  
 * @ClassName: ImplBoardDao  
 * @Description: 实现餐桌的数据操作接口 
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class ImplBoardDao extends ImplBaseDao<Board> implements IBoardDao  {

	/*  
	* <p>Title: FindAll</p>  
	* <p>Description:通过名称查找餐桌</p>  
	* @param boardName
	* @return  
	* @see com.briup.www.food.dao.IBoardDao#FindAll(java.lang.String)  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Board> FindAll(String boardName) {
		Query query = currentSession().createQuery("from Board  where boardName=?");
		query.setString(0, boardName);
		return query.list();
	}

	/*  
	* <p>Title: getAll</p>  
	* <p>Description:分页查询</p>  
	* @param pageBean  
	* @see com.briup.www.food.dao.IBoardDao#getAll(com.briup.www.food.entity.PageBean)  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public void getAll(PageBean<Board> pageBean) {
		//获取总的记录数
		pageBean.setAllPageColum(getAllPageColum());
		//获取当前页
		long currentPage = pageBean.getCurrentPage();
		//获取第一页的行数
		long count = pageBean.getPageCount();
		//进行查询
		SQLQuery query = currentSession().createSQLQuery("select * from board limit ?,?");
		query.setParameter(0, (currentPage-1)*count);
		query.setParameter(1, count);
		query.addEntity(Board.class);
		List<Board> list = query.list();
		pageBean.setPageList(list);
	}

	/*  
	* <p>Title: getAllPageColum</p>  
	* <p>Description:查询总的记录数 </p>  
	* @return  
	* @see com.briup.www.food.dao.IBoardDao#getAllPageColum()  
	*/
	@Override
	public long getAllPageColum() {
		SQLQuery query = currentSession().createSQLQuery("select count(*) from board");
		Number count = (Number)query.uniqueResult();
		count.longValue();
		return count.longValue();
	}

	/*  
	* <p>Title: getBoardName</p>  
	* <p>Description:获取所有餐桌的名称</p>  
	* @return  
	* @see com.briup.www.food.dao.IBoardDao#getBoardName()  
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getBoardName() {
		SQLQuery query = currentSession().createSQLQuery("select boardName from board");
		return query.list();
	}

}
