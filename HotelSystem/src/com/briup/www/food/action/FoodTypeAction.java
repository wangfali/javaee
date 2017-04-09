package com.briup.www.food.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.briup.www.food.entity.FoodType;
import com.briup.www.food.entity.PageBean;
import com.briup.www.food.service.IFoodTypeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**  
 * @ClassName: FoodTypeAction  
 * @Description: 菜系业务层的处理  
 * @author wangfali
 * @date 2017年3月28日  
 * @version V1.0  
 */
public class FoodTypeAction extends ActionSupport implements ModelDriven<FoodType>{
	private static final long serialVersionUID = 1L;
	@Resource
	private IFoodTypeService ifoodTypeService;
	private FoodType foodType=new FoodType();
	private List<FoodType> foodTypeList;
	private int findResult;
	private long pageCount;
	private long allPageCount;
	//展现菜系列表
	public  String caixiUI()throws Exception{
		foodTypeList=ifoodTypeService.FindAll();
		pageCount=1;
		return "caixiUI";
	}
	//删除菜系列表
	public String delete() throws Exception{
		ifoodTypeService.delete(foodType.getId());
		return "caixi";
	}
	//添加菜系视图
	public String addcaixiUI() throws Exception{
		return "addcaixiUI";
	}
	//确认添加菜系
	public String addcaixi() throws Exception{
		ifoodTypeService.save(foodType);
		return "caixi";
	}
	//更新菜系
	public String upcaixiUI() throws Exception{
		foodType = ifoodTypeService.FindByid(foodType.getId());
		System.out.println(foodType.getTypeName());
		return "upcaixiUI";
	}
	//确认更新菜系
	public String upcaixi() throws Exception{
		ifoodTypeService.update(foodType);
		return "caixi";
	}
	//验证菜名是否重复
	public void verifyTypeName() throws Exception{
		List<FoodType> list = ifoodTypeService.FindAll(foodType.getTypeName());
		String result="null";
		if(list!=null && list.size()>0){
			result="shi";
			}else{
				result="fou";
			}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.close();
	}
	//搜索
		public String findByName()throws Exception{
			foodTypeList= ifoodTypeService.FindAll(foodType.getTypeName());
			if(foodTypeList!=null && foodTypeList.size()>0){
				findResult=0;
			}else{
				findResult=1;
			}
			return "caixiUI";
		}
		//分页查询
		public String page() throws Exception{
			//获取当前页的信息进行封装
			PageBean<FoodType> pageBean = new PageBean<FoodType>();
			pageBean.setCurrentPage(pageCount);
			ifoodTypeService.getAll(pageBean);
			foodTypeList=pageBean.getPageList();
			allPageCount = pageBean.getAllPageCount();
			System.out.println(allPageCount);
			return "caixiUI";
		}
	public List<FoodType> getFoodTypeList() {
		return foodTypeList;
	}
	public void setFoodTypeList(List<FoodType> foodTypeList) {
		this.foodTypeList = foodTypeList;
	}
	@Override
	public FoodType getModel() {
		return foodType;
	}
	public FoodType getFoodType() {
		return foodType;
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	public int getFindResult() {
		return findResult;
	}
	public void setFindResult(int findResult) {
		this.findResult = findResult;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getAllPageCount() {
		return allPageCount;
	}
	public void setAllPageCount(long allPageCount) {
		this.allPageCount = allPageCount;
	}
	
}
