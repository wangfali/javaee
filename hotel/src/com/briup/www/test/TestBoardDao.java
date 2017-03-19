package com.briup.www.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.briup.www.dao.IBoardDao;
import com.briup.www.dao.Impl.ImplBoardDao;
import com.briup.www.entity.Board;

/**
 *测试餐桌数据的操作
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
public class TestBoardDao {
	IBoardDao operate;
	@Before
	public void init(){
		operate=new ImplBoardDao();
	}
	@Test
	public void test1() throws Exception{
		operate.save(new Board(1,"江西",1,new Date()));
	}
	@Test
	public void test2() throws Exception{
		List<Board> findAll = operate.FindAll();
		System.out.println(findAll);
	}
	@Test
	public void test3() throws Exception{
		Board board = operate.FindByid(1);
		System.out.println(board);
	}
	@Test
	public void test4() throws Exception{
		List<Board> findAll = operate.FindAll("为%");
		System.out.println(findAll);
	}
	@Test
	public void test5() throws Exception{
		operate.update(new Board(1,"江南",2,new Date()));
	}
	@Test
	public void test6() throws Exception{
		operate.delete(1l);
	}
}
