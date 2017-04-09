package com.briup.www.food.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.briup.www.food.dao.IFoodDao;
import com.briup.www.food.dao.IFoodTypeDao;
import com.briup.www.food.entity.Food;
import com.briup.www.food.entity.PageBean;
import com.briup.www.food.service.IFoodService;

/**  
 * @ClassName: ImplFoodService  
 * @Description:业务层菜品的操作 
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class ImplFoodService implements IFoodService {
	@Resource
	private IFoodDao iFoodDao;
	@Resource
	private IFoodTypeDao ifoodTypeDao;
	/*  
	 * <p>Title: delete</p>  
	 * <p>Description:通过id删除菜品 </p>  
	 * @param id  
	 * @see com.briup.www.food.service.IFoodService#delete(java.lang.String)  
	 */
	@Override
	public void delete(String id) {
			iFoodDao.delete(id);
	}

	/*  
	 * <p>Title: save</p>  
	 * <p>Description:保存菜品</p>  
	 * @param food  
	 * @see com.briup.www.food.service.IFoodService#save(com.briup.www.food.entity.Food)  
	 */
	@Override
	public void save(Food food) {
		iFoodDao.save(food);
	}

	/*  
	 * <p>Title: update</p>  
	 * <p>Description: </p>  
	 * @param food  
	 * @see com.briup.www.food.service.IFoodService#update(com.briup.www.food.entity.Food)  
	 */
	@Override
	public void update(Food food) {
		iFoodDao.update(food);
	}

	/*  
	 * <p>Title: FindAll</p>  
	 * <p>Description:更新菜品</p>  
	 * @return  
	 * @see com.briup.www.food.service.IFoodService#FindAll()  
	 */
	@Override
	public List<Food> FindAll() {
		return iFoodDao.findObjects();
	}

	/*  
	 * <p>Title: FindByid</p>  
	 * <p>Description:通过主键查找菜品</p>  
	 * @param id
	 * @return  
	 * @see com.briup.www.food.service.IFoodService#FindByid(java.lang.String)  
	 */
	@Override
	public Food FindByid(Serializable id) {
		return iFoodDao.findObjectById(id);
	}

	/*  
	 * <p>Title: FindAll</p>  
	 * <p>Description: 通过名称查找菜品</p>  
	 * @param foodName
	 * @return  
	 * @see com.briup.www.food.service.IFoodService#FindAll(java.lang.String)  
	 */
	@Override
	public List<Food> FindAll(String foodName) {
		return iFoodDao.findAll(foodName);
	}

	/*  
	 * <p>Title: getAll</p>  
	 * <p>Description: 分页查询所有菜品</p>  
	 * @param pageBean  
	 * @see com.briup.www.food.service.IFoodService#getAll(com.briup.www.food.entity.PageBean)  
	 */
	@Override
	public void getAll(PageBean<Food> pageBean) {
		iFoodDao.getAll(pageBean);
	}

	/*  
	* <p>Title: findFoodTypeName</p>  
	* <p>Description:查询所有的菜系名称 </p>  
	* @return  
	* @see com.briup.www.food.service.IFoodService#findFoodTypeName()  
	*/
	@Override
	public List<String> findFoodTypeName() {
		return ifoodTypeDao.findAllName();
	}

	/*  
	* <p>Title: findByFoodTypeName</p>  
	* <p>Description:通过菜系名称查找菜品</p>  
	* @param foodTypeName
	* @return  
	* @see com.briup.www.food.service.IFoodService#findByFoodTypeName(java.lang.String)  
	*/
	@Override
	public List<Food> findByFoodTypeName(String foodTypeName) {
		return iFoodDao.findByFoodType(foodTypeName);
	}

}
