package com.briup.www.food.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.briup.www.food.dao.IFoodTypeDao;
import com.briup.www.food.entity.FoodType;
import com.briup.www.food.entity.PageBean;
import com.briup.www.food.service.IFoodTypeService;

/**  
 * @ClassName: ImplFoodTypeService  
 * @Description: 实现业务层的接口  
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class ImplFoodTypeService implements IFoodTypeService {
	@Resource
	private IFoodTypeDao iFoodTypeDao;
	/*  
	 * <p>Title: delete</p>  
	 * <p>Description:删除菜系</p>  
	 * @param id  
	 * @see com.briup.www.food.service.IFoodTypeService#delete(java.lang.String)  
	 */
	@Override
	public void delete(String id) {
		iFoodTypeDao.delete(id);
	}

	/*  
	 * <p>Title: save</p>  
	 * <p>Description:保存菜系</p>  
	 * @param foodType  
	 * @see com.briup.www.food.service.IFoodTypeService#save(com.briup.www.food.entity.FoodType)  
	 */
	@Override
	public void save(FoodType foodType) {
		iFoodTypeDao.save(foodType);
	}

	/*  
	 * <p>Title: update</p>  
	 * <p>Description:更新菜系</p>  
	 * @param foodType  
	 * @see com.briup.www.food.service.IFoodTypeService#update(com.briup.www.food.entity.FoodType)  
	 */
	@Override
	public void update(FoodType foodType) {
		iFoodTypeDao.update(foodType);
	}

	/*  
	 * <p>Title: FindAll</p>  
	 * <p>Description:查询所有菜系</p>  
	 * @return  
	 * @see com.briup.www.food.service.IFoodTypeService#FindAll()  
	 */
	@Override
	public List<FoodType> FindAll() {
		return iFoodTypeDao.findObjects();
	}

	/*  
	 * <p>Title: FindByid</p>  
	 * <p>Description:通过主键查询菜系</p>  
	 * @param id
	 * @return  
	 * @see com.briup.www.food.service.IFoodTypeService#FindByid(java.lang.String)  
	 */
	@Override
	public FoodType FindByid(String id) {
		return iFoodTypeDao.findObjectById(id);
	}

	/*  
	 * <p>Title: FindAll</p>  
	 * <p>Description:通过菜系名称查询菜系</p>  
	 * @param typename
	 * @return  
	 * @see com.briup.www.food.service.IFoodTypeService#FindAll(java.lang.String)  
	 */
	@Override
	public List<FoodType> FindAll(String typename) {
		return iFoodTypeDao.findAll(typename);
	}

	/*  
	* <p>Title: getAll</p>  
	* <p>Description:分页查询菜系</p>  
	* @param pageBean  
	* @see com.briup.www.food.service.IFoodTypeService#getAll(com.briup.www.food.entity.PageBean)  
	*/
	@Override
	public void getAll(PageBean<FoodType> pageBean) {
		iFoodTypeDao.getAll(pageBean);
	}

	/*  
	* <p>Title: getAnalyse</p>  
	* <p>Description:获取菜系分析</p>  
	* @return  
	* @see com.briup.www.food.service.IFoodTypeService#getAnalyse()  
	*/
	@Override
	public List<Map<String,String>> getAnalyse() {
		List<Map<String, String>> listmap= new ArrayList<Map<String,String>>();
		//获取查询到的数据
		List<Object[]> list = iFoodTypeDao.getAnalyse();
		Map<String, String> map=null;
		//判断是否为空
		if(list!=null&&list.size()>0){
			//格式化统计结果
			//遍历统计的结果
			for (Object[] objects : list) {
				map=new HashMap<String,String>();
				String foodType=String.valueOf(objects[0]+"菜系");
				map.put("label", foodType);
				map.put("value",String.valueOf(objects[1])+"种菜品");
				listmap.add(map);
			}
		}
		//将数据封装返回
		
		return listmap;
		
	}

}
