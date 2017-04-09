package com.briup.www.food.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.briup.www.food.dao.IBoardDao;
import com.briup.www.food.entity.Board;
import com.briup.www.food.entity.PageBean;
import com.briup.www.food.service.IBoardService;

/**  
 * @ClassName: ImplBoardService  
 * @Description: 业务层的餐桌数据操作的实现  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class ImplBoardService implements IBoardService{
	@Resource
	private IBoardDao iBoardDao;
	/*  
	* <p>Title: delete</p>  
	* <p>Description:通过主键删除餐桌</p>  
	* @param id  
	* @see com.briup.www.food.service.IBoardService#delete(java.lang.String)  
	*/
	@Override
	public void delete(String id) {
			iBoardDao.delete(id);
	}

	/*  
	* <p>Title: save</p>  
	* <p>Description:保存餐桌对象</p>  
	* @param board  
	* @see com.briup.www.food.service.IBoardService#save(com.briup.www.food.entity.Board)  
	*/
	@Override
	public void save(Board board) {
			iBoardDao.save(board);
	}

	/*  
	* <p>Title: update</p>  
	* <p>Description:更新餐桌对象</p>  
	* @param board  
	* @see com.briup.www.food.service.IBoardService#update(com.briup.www.food.entity.Board)  
	*/
	@Override
	public void update(Board board) {
		iBoardDao.update(board);
	}

	
	/*  
	* <p>Title: FindByid</p>  
	* <p>Description:通过主键查找餐桌对象</p>  
	* @param id
	* @return  
	* @see com.briup.www.food.service.IBoardService#FindByid(java.lang.String)  
	*/
	@Override
	public Board FindByid(String id) {
		return iBoardDao.findObjectById(id);
	}
	/*  
	* <p>Title: FindAll</p>  
	* <p>Description:查询所有餐桌</p>  
	* @return  
	* @see com.briup.www.food.service.IBoardService#FindAll()  
	*/
	@Override
	public List<Board> FindAll() {
		
		return iBoardDao.findObjects();
	}

	/*  
	* <p>Title: FindAll</p>  
	* <p>Description:通过名称查询餐桌</p>  
	* @param boardName
	* @return  
	* @see com.briup.www.food.service.IBoardService#FindAll(java.lang.String)  
	*/
	@Override
	public List<Board> FindAll(String boardName) {
		List<Board> list = iBoardDao.FindAll(boardName);
		return list;
	}

	/*  
	* <p>Title: getAll</p>  
	* <p>Description:分页查询餐桌</p>  
	* @param pageBean  
	* @see com.briup.www.food.service.IBoardService#getAll(com.briup.www.food.entity.PageBean)  
	*/
	@Override
	public void getAll(PageBean<Board> pageBean) {
		iBoardDao.getAll(pageBean);
	}

	/*  
	* <p>Title: getBoradName</p>  
	* <p>Description:查询所有的餐桌名称</p>  
	* @return  
	* @see com.briup.www.food.service.IBoardService#getBoradName()  
	*/
	@Override
	public List<String> getBoradName() {
		return iBoardDao.getBoardName();
	}

}
