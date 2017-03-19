package com.briup.www.dao.Impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.briup.www.dao.IFoodTypeDao;
import com.briup.www.entity.FoodType;
import com.briup.www.util.DataBaseConnectFactry;

/**
 * 实现菜系数据的操作
 * @author wangfali
 *@version 1.0
 *@date 2016年12月12日
 */
public class FoodTypeDao implements IFoodTypeDao{

	@Override
	public void delete(int id) throws Exception {
		String sql="delete from FoodType where id=?";
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, sql, id);
		connection.close();
		
	}

	@Override
	public void save(FoodType foodType) throws Exception {
		String sql="insert into FoodType(typeName) values(?)";
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(DataBaseConnectFactry.getConnection(), sql, foodType.getTypeName());
		connection.close();
	}

	@Override
	public void update(FoodType foodType) throws Exception {
		String sql="update FoodType set typeName=? where id=?";
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, sql, foodType.getTypeName(),foodType.getId());
		connection.close();
	}

	@Override
	public List<FoodType> FindAll() throws Exception {
		String sql="select * from FoodType";
		Connection connection = DataBaseConnectFactry.getConnection();
		List<FoodType> list = new QueryRunner().query(connection, sql, new BeanListHandler<FoodType>(FoodType.class));
		connection.close();
		return list;
	}

	@Override
	public FoodType FindByid(int id) throws Exception {
		String sql="select * from FoodType where id=?";
		Connection connection = DataBaseConnectFactry.getConnection();
		FoodType foodType = new QueryRunner().query(connection, sql, new BeanHandler<FoodType>(FoodType.class), id);
		connection.close();
		return foodType;
	}

	@Override
	public List<FoodType> FindAll(String typename) throws Exception {
		String sql="select *from FoodType where typeName like ?";
		Connection connection = DataBaseConnectFactry.getConnection();
		List<FoodType> list = new QueryRunner().query(connection, sql,new BeanListHandler<FoodType>(FoodType.class), typename);
		connection.close();
		return list;
	}

}
