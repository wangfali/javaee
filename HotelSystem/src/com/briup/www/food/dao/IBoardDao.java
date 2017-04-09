package com.briup.www.food.dao;

import java.util.List;

import com.briup.www.core.dao.IBaseDao;
import com.briup.www.food.entity.Board;
import com.briup.www.food.entity.PageBean;

/**  
 * @ClassName: IBoardDao  
 * @Description:餐桌的数据操作接口  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public interface IBoardDao extends IBaseDao<Board>{
	/**
	* @Title: FindAll  
	* @Description: 通过名称查找餐桌  
	* @param @param boardName
	* @param @return 
	* @return List<Board>  
	* @throws
	 */
	 List<Board>FindAll(String boardName);
	 /**
	  * 
	 * @Title: getAll  
	 * @Description: 分页查询 
	 * @param @param pageBean 
	 * @return void  
	 * @throws
	  */
	 void getAll(PageBean<Board> pageBean);
	 /**
	  * 
	 * @Title: getAllPageColum  
	 * @Description: 查询总的记录数  
	 * @param @return 
	 * @return long  
	 * @throws
	  */
	 long getAllPageColum();
	 /**
	  * 
	 * @Title: getBoardName  
	 * @Description: 获取所有餐桌的名称 
	 * @param @return 
	 * @return List<String>  
	 * @throws
	  */
	 List<String>getBoardName();
}
