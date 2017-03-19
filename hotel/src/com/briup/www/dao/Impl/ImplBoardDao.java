package com.briup.www.dao.Impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.briup.www.dao.IBoardDao;
import com.briup.www.entity.Board;
import com.briup.www.util.DataBaseConnectFactry;

/**
 * 实现餐桌操作接口
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
public class ImplBoardDao implements IBoardDao{

	@Override
	public void delete(long id) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, new String("delete from board where id=?"), id);
		connection.close();
	}

	@Override
	public void save(Board board) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, new String("insert into board(boardName,state,time) values(?,?,?)"),board.getBoardName(),board.getState(),board.getTime());
		connection.close();
		
	}

	@Override
	public void update(Board board) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		new QueryRunner().update(connection, new String("update board set boardName=?,state=?,time=? where id=?"),board.getBoardName(),board.getState(),board.getTime(),board.getId());
		connection.close();
		
	}

	@Override
	public List<Board> FindAll() throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		List<Board> list = new QueryRunner().query(connection, new String("select * from board"),new BeanListHandler<Board>(Board.class));
		connection.close();
		return list;
	}

	@Override
	public Board FindByid(long id) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		Board board = new QueryRunner().query(connection, new String("select * from board where id=?"), new BeanHandler<Board>(Board.class),id);
		connection.close();
		return board;
	}

	@Override
	public List<Board> FindAll(String boardName) throws Exception {
		Connection connection = DataBaseConnectFactry.getConnection();
		List<Board> list = new QueryRunner().query(connection, new String("select * from board where boardName like ?"),new BeanListHandler<Board>(Board.class),boardName);
		connection.close();
		return list;
	}

}
