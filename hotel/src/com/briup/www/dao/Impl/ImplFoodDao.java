package com.briup.www.dao.Impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.briup.www.dao.IFoodDao;
import com.briup.www.entity.Food;
import com.briup.www.entity.PageBean;
import com.briup.www.util.DataBaseConnectFactry;

/**
 * 实现菜品数据操作接口
 * @author wangfali
 *@version 1.0
 *@date 2016年12月18日
 */
public class ImplFoodDao implements IFoodDao{

	@Override
	public void delete(long id) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, new String("delete from food where id=?"), id);
		connection.close();
		
	}

	@Override
	public void save(Food food) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, new String("insert into food(foodName,foodType,price,vipPrice,text,imagePath) values(?,?,?,?,?,?)"),food.getFoodName(),food.getFoodType(),food.getPrice(),food.getVipPrice(),food.getText(),food.getImagePath());
		connection.close();
		
	}

	@Override
	public void update(Food food) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, new String("update food set foodName=?,foodType=?,price=?,vipPrice=?,text=?,imagePath=? where id=?"),food.getFoodName(),food.getFoodType(),food.getPrice(),food.getVipPrice(),food.getText(),food.getImagePath(),food.getId());
		connection.close();
		
	}

	@Override
	public List<Food> FindAll() throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		List<Food> list = new QueryRunner().query(connection, new String("select * from food"),new BeanListHandler<Food>(Food.class));
		connection.close();
		return list;
	}

	@Override
	public Food FindByid(long id) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		Food food = new QueryRunner().query(connection, new String("select * from food where id=?"), new BeanHandler<Food>(Food.class),id);
		connection.close();
		return food;
	}

	@Override
	public List<Food> FindAll(String foodName) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		List<Food> list = new QueryRunner().query(connection, new String("select *from food where foodName like ?"),new BeanListHandler<Food>(Food.class),foodName);
		connection.close();
		return list;
	}

	@Override
	public void getAll(PageBean<Food> pageBean) throws Exception {
		//创建连接
		Connection connection = DataBaseConnectFactry.getConnection();
		//获取总的记录数
		pageBean.setAllPageColum(getAllPageColum());
		//获取当前页
		long currentPage = pageBean.getCurrentPage();
		//获取一页显示的行数
		long count = pageBean.getPageCount();
		//进行查询
		List<Food> list = new QueryRunner().query(connection, new String("select * from food limit ?,?"),new BeanListHandler<Food>(Food.class),(currentPage-1)*count,count);
		pageBean.setPageList(list);
		//关闭资源
		connection.close();
	}

	@Override
	public long getAllPageColum() throws Exception {
		//获取连接对象
		Connection connection = DataBaseConnectFactry.getConnection();
		//进行数据的查询
		Long query = new QueryRunner().query(connection, new String("select count(*) from food"),new ScalarHandler<Long>());
		//关闭资源
		connection.close();
		return query.longValue();
	}

}
