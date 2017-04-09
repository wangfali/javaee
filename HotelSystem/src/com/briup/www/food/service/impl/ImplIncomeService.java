package com.briup.www.food.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.briup.www.food.dao.IIncomeDao;
import com.briup.www.food.entity.Income;
import com.briup.www.food.service.IIncomeService;

/**
 * @ClassName: ImplIncomeService
 * @Description: 实现年度总结
 * @author wangfali
 * @date 2017年4月4日
 * @version V1.0
 */
public class ImplIncomeService implements IIncomeService {
	@Resource
	private IIncomeDao iIncomeDao;

	/*
	 * <p>Title: getSumary</p> <p>Description:获取年度总计</p>
	 * 
	 * @return
	 * 
	 * @see com.briup.www.food.service.IIncomeService#getSumary()
	 */
	@Override
	public List<Map<String, String>> getSumary() {
		// 创建一个用于返回数据的结合
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		// 获取查询到的数据
		List<Object[]> list = iIncomeDao.getSumary();
		// 创建一个map集合
		Map<String, String> map = null;
		// 判断查询到的数据是否为空
		if (list != null && list.size() > 0) {
			// 开始遍历数组
			for (Object[] objects : list) {
				// 创建一个新的集合
				map = new HashMap<String, String>();
				// 将第一个数据遍历出来加上标签
				String month = String.valueOf(objects[0]) + "月";
				map.put("label", month);
				// 将第二个值遍历处理加上标签
				String value = String.valueOf(objects[1]);
				// 加入map集合当中
				map.put("value", value);
				// 将map添加到list集合当中
				listMap.add(map);
			}
		}
		// 返回集合
		return listMap;
	}

	/*
	 * <p>Title: getBoardSumary</p> <p>Description:获取年度订餐量</p>
	 * 
	 * @return
	 * 
	 * @see com.briup.www.food.service.IIncomeService#getBoardSumary()
	 */
	@Override
	public List<Map<String, String>> getBoardSumary() {
		// 创建一个用于返回数据的结合
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		// 获取查询到的数据
		List<Object[]> list = iIncomeDao.getBoardSumary();
		// 创建一个map集合
		Map<String, String> map = null;
		// 判断查询到的数据是否为空
		if (list != null && list.size() > 0) {
			// 开始遍历数组
			for (Object[] objects : list) {
				// 创建一个新的集合
				map = new HashMap<String, String>();
				// 将第一个数据遍历出来加上标签
				String month = String.valueOf(objects[0]) + "月";
				map.put("label", month);
				// 将第二个值遍历处理加上标签
				String value = String.valueOf(objects[1]);
				// 加入map集合当中
				map.put("value", value);
				// 将map添加到list集合当中
				listMap.add(map);
			}
		}
		// 返回集合
		return listMap;
	}

	/*
	 * <p>Title: save</p> <p>Description:保存收入</p>
	 * 
	 * @param income
	 * 
	 * @see
	 * com.briup.www.food.service.IIncomeService#save(com.briup.www.food.entity
	 * .Income)
	 */
	@Override
	public void save(Income income) {
		iIncomeDao.save(income);
	}

	/*
	 * <p>Title: getCustmer</p> <p>Description:获取年度客流量分析</p>
	 * 
	 * @return
	 * 
	 * @see com.briup.www.food.service.IIncomeService#getCustmer()
	 */
	@Override
	public List<Map<String, String>> getCustmer() {
		// 创建一个用于返回数据的结合
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		// 获取查询到的数据
		List<Object[]> list = iIncomeDao.getCustmer();
		// 创建一个map集合
		Map<String, String> map = null;
		// 判断查询到的数据是否为空
		if (list != null && list.size() > 0) {
			// 开始遍历数组
			for (Object[] objects : list) {
				// 创建一个新的集合
				map = new HashMap<String, String>();
				// 将第一个数据遍历出来加上标签
				String month = String.valueOf(objects[0]) + "月";
				map.put("label", month);
				// 将第二个值遍历处理加上标签
				String value = String.valueOf(objects[1]);
				// 加入map集合当中
				map.put("value", value);
				// 将map添加到list集合当中
				listMap.add(map);
			}
		}
		// 返回集合
		return listMap;
	}

}
