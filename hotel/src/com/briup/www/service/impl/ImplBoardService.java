package com.briup.www.service.impl;

import java.util.List;

import com.briup.www.dao.Impl.ImplBoardDao;
import com.briup.www.entity.Board;
import com.briup.www.exception.TypeNameExistException;
import com.briup.www.service.IBoardService;

/**
 * 业务层的餐桌数据操作的实现
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
public class ImplBoardService implements IBoardService{

	@Override
	public void delete(long id) throws Exception {
		
		
	}

	@Override
	public void save(Board board) throws Exception {
		//判断餐桌名是否重复
		ImplBoardDao implBoardDao = new ImplBoardDao();
		if(implBoardDao.FindAll(board.getBoardName()).isEmpty()){
			implBoardDao.save(board);
		}else {
			throw new TypeNameExistException("该餐桌已经存在");
		}
		
	}

	@Override
	public void update(Board board) throws Exception {
		new ImplBoardDao().update(board);
		
	}

	@Override
	public List<Board> FindAll() throws Exception {
		List<Board> list = new  ImplBoardDao().FindAll();
		return list;
	}

	@Override
	public Board FindByid(long id) throws Exception {
		
		return null;
	}

	@Override
	public List<Board> FindAll(String boardName) throws Exception {
		List<Board> findAll = new ImplBoardDao().FindAll(boardName);
		return findAll;
	}

}
