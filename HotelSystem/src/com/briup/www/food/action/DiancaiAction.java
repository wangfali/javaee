package com.briup.www.food.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.briup.www.food.entity.Food;
import com.briup.www.food.service.IBoardService;
import com.briup.www.food.service.IFoodService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: DiancaiAction
 * @Description: 点菜类
 * @author wangfali
 * @date 2017年4月5日
 * @version V1.0
 */
public class DiancaiAction extends ActionSupport implements ModelDriven<Food> {
	private static final long serialVersionUID = 1L;
	@Resource
	private IFoodService iFoodService;
	@Resource
	private IBoardService iBoardService;
	// 模型驱动
	private Food food = new Food();
	// 返回菜品集合
	private List<Food> foodList;
	// 创建属性进行属性驱动
	private String count;
	// 创建餐桌数组
	private List<String> boardNameList;

	// 显示菜单
	public String caidanUI() throws Exception {
		// 通过菜系名称查询菜品
		String name = food.getFoodType();
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		foodList = iFoodService.findByFoodTypeName(name);
		return "caidanUI";
	}

	// 转换为订单页面
	public String jiezhangUI() throws Exception {
		// 定义一个集合
		foodList = new ArrayList<Food>();
		// 创建servlet对象
		Map<String, Object> map = ActionContext.getContext().getSession();
		// 获取键值
		int key = Integer.parseInt(count);
		// 遍历集合获取id
		for (int i = 1; i <= key; i++) {
			// 获取id
			String str = (String) map.get(Integer.toString(i));
			// 判断id是否为空
			if (str != null && "" != str) {
				// 通过id查询
				foodList.add(iFoodService.FindByid(str));
			}
		}
		boardNameList = iBoardService.getBoradName();
		return "jiezhangUI";
	}
	//删除已经选择的菜单
	public String delete()throws Exception{
		
		return "list";
	}
	@Override
	public Food getModel() {
		return food;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<String> getBoardNameList() {
		return boardNameList;
	}

	public void setBoardNameList(List<String> boardNameList) {
		this.boardNameList = boardNameList;
	}

}
