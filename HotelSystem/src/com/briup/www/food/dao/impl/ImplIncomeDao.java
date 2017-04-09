package com.briup.www.food.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SQLQuery;

import com.briup.www.core.dao.impl.ImplBaseDao;
import com.briup.www.food.dao.IIncomeDao;
import com.briup.www.food.entity.Income;

/**  
 * @ClassName: ImplIncomeDao  
 * @Description: 实现接口  
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public class ImplIncomeDao extends ImplBaseDao<Income> implements IIncomeDao{

	/*  
	* <p>Title: getSumary</p>  
	* <p>Description:获取年度总结数据</p>  
	* @return  
	* @see com.briup.www.food.dao.IIncomeDao#getSumary()  
	*/
	@Override
	public List<Object[]> getSumary() {
		//获取今年的年份
		int year=Calendar.YEAR;
		//查询属于本年度的月份的钱
		SQLQuery query = currentSession().createSQLQuery("select month,sum(money) from income where year=? GROUP BY month ORDER BY money");
		query.setParameter(0, year);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		return list;
	}

	/*  
	* <p>Title: getBoardSumary</p>  
	* <p>Description:获取年度订餐量</p>  
	* @return  
	* @see com.briup.www.food.dao.IIncomeDao#getBoardSumary()  
	*/
	@Override
	public List<Object[]> getBoardSumary() {
		//获取今年年份
		int year=Calendar.YEAR;
		//查询属于本年度的定餐量
		SQLQuery query = currentSession().createSQLQuery("select month,count(*) from income where year=? GROUP BY month ORDER BY money");
		query.setParameter(0, year);
		@SuppressWarnings("unchecked")
		List<Object[]> list=query.list();
		return list;
	}

	/*  
	* <p>Title: getCustmer</p>  
	* <p>Description:年度客流量分析</p>  
	* @return  
	* @see com.briup.www.food.dao.IIncomeDao#getCustmer()  
	*/
	@Override
	public List<Object[]> getCustmer() {
		// 获取今年年份
		int year = Calendar.YEAR;
		// 查询属于本年度的定餐量
		SQLQuery query = currentSession().createSQLQuery(
				"select month,count(*)*10 from income where year=? GROUP BY month ORDER BY money");
		query.setParameter(0, year);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		return list;
	}

}
