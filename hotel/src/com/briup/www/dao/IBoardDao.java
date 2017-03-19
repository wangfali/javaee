package com.briup.www.dao;

import java.util.List;

import com.briup.www.entity.Board;

/**
 * 餐桌的数据操作接口
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
public interface IBoardDao {
		/**
		 * 通过id删除餐桌
		 *@return void
		 *@param @param id
		 * @throws Exception 
		 *
		 */
		 void delete(long id) throws Exception;
		 /**
		  * 保存餐桌
		  *@return void
		  *@param @param foodType
		 * @throws Exception 
		  *
		  */
		 void save(Board board) throws Exception;
		 /**
		  * 更新餐桌
		  *@return void
		  *@param @param foodType
		 * @throws Exception 
		  *
		  */
		 void update(Board board) throws Exception;
		 /**
		  * 显示所有的餐桌
		  *@return List<FoodType>
		  *@param @return
		 * @throws Exception 
		  *
		  */
		 List<Board>FindAll() throws Exception;
		 /**
		  * 通过id查找餐桌
		  *@return FoodType
		  *@param @param id
		  *@param @return
		 * @throws Exception 
		  *
		  */
		 Board FindByid(long id) throws Exception;
		 /**
		  *根据名称查询餐桌 
		 * @throws Exception 
		  */
		 List<Board>FindAll(String boardName) throws Exception;
		 
}
