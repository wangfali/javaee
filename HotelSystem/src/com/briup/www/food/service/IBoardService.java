package com.briup.www.food.service;

import java.util.List;



import com.briup.www.food.entity.Board;
import com.briup.www.food.entity.PageBean;


/**  
 * @ClassName: IBoardService  
 * @Description: 餐桌业务层接口  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public interface IBoardService {
	/**
	 * 
	* @Title: delete  
	* @Description: 通过id删除餐桌 
	* @param @param id 
	* @return void  
	* @throws
	 */
	 void delete(String id);
	 /**
	  * 
	 * @Title: save  
	 * @Description: 保存餐桌  
	 * @param @param board 
	 * @return void  
	 * @throws
	  */
	 void save(Board board);
	 /**
	  * 
	 * @Title: update  
	 * @Description: 更新餐桌 
	 * @param @param board 
	 * @return void  
	 * @throws
	  */
	 void update(Board board);
	 /**
	  * 
	 * @Title: FindAll  
	 * @Description: 显示所有的餐桌 
	 * @param @return 
	 * @return List<Board>  
	 * @throws
	  */
	 List<Board>FindAll();
	 /**
	  * 
	 * @Title: FindByid  
	 * @Description: 通过id查找餐桌  
	 * @param @param id
	 * @param @return 
	 * @return Board  
	 * @throws
	  */
	 Board FindByid(String id);
	 /**
	  * 
	 * @Title: FindAll  
	 * @Description: 根据名称查询餐桌  
	 * @param @param boardName
	 * @param @return
	 * @param @throws Exception 
	 * @return List<Board>  
	 * @throws
	  */
	 List<Board>FindAll(String boardName);
	 /**
	  * 
	 * @Title: getAll  
	 * @Description: 分页查询餐桌  
	 * @param @param pageBean 
	 * @return void  
	 * @throws
	  */
	 void getAll(PageBean<Board>pageBean);
	 /**
	  * 
	 * @Title: getBoradName  
	 * @Description: 查询所有餐桌的名称  
	 * @param @return 
	 * @return List<String>  
	 * @throws
	  */
	 List<String>getBoradName();
}
