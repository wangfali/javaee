package com.briup.www.food.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.briup.www.food.entity.Food;
import com.briup.www.food.entity.PageBean;
import com.briup.www.food.service.IFoodService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**  
 * @ClassName: FoodAction  
 * @Description:处理菜品的表示层  
 * @author wangfali
 * @date 2017年3月28日  
 * @version V1.0  
 */
public class FoodAction extends ActionSupport implements ModelDriven<Food>{
	@Resource
	private IFoodService iFoodService;
	private Food food=new Food();
	private static final long serialVersionUID = 1L;
	private List<Food>foodList;
	private List<String>foodTypeList;
	private File image;
	private String imageFileName;
	private String imageContentType;
	private int findResult;
	private long pageCount;
	private long allPageCount;
	
	public String foodUI() throws Exception{
		foodList=iFoodService.FindAll();
		pageCount=1;
		return "foodUI";
	}
	public String addFoodUI() throws Exception{
		foodTypeList=iFoodService.findFoodTypeName();
		return "addFoodUI";
	}
	//添加菜
	public String addFood() throws Exception{
		//获取保存图片路径
		String path = ServletActionContext.getServletContext().getRealPath("upload");
		//加工图片地址
		String filename=UUID.randomUUID().toString().replaceAll("-", "")+imageFileName.substring(imageFileName.lastIndexOf("."));
		//保存图片的真实地址到数据库当中
		food.setImagePath(filename);
		System.out.println(image);
		//复制文件当文件夹当中
		FileUtils.copyFile(image,new File(path,filename));		
		//保存菜品
		iFoodService.save(food);
		return "food";
	}
	//验证菜名是否重复
	public void verifyFoodName()throws Exception{
		List<Food> list = iFoodService.FindAll(food.getFoodName());
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
	//删除
	public String delete()throws Exception{
		iFoodService.delete(food.getId());
		return "food";
	}
	//更新菜品
	public String upfoodUI()throws Exception{
		foodTypeList=iFoodService.findFoodTypeName();
		//数据回显
		food=iFoodService.FindByid(food.getId());
		return "upfoodUI";
	}
	//确认更新菜品
	public String update() throws Exception{
		iFoodService.update(food);
		return "food";
	}
	//搜索
		public String findByName()throws Exception{
			foodList= iFoodService.FindAll(food.getFoodName());
			if(foodList!=null && foodList.size()>0){
				findResult=0;
			}else{
				findResult=1;
			}
			return "foodUI";
		}
		//分页查询
		public String page() throws Exception{
			//获取当前页的信息进行封装
			PageBean<Food> pageBean = new PageBean<Food>();
			pageBean.setCurrentPage(pageCount);
			iFoodService.getAll(pageBean);
			foodList=pageBean.getPageList();
			allPageCount = pageBean.getAllPageCount();
			System.out.println(allPageCount);
			return "foodUI";
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
	public List<String> getFoodTypeList() {
		return foodTypeList;
	}
	public void setFoodTypeList(List<String> foodTypeList) {
		this.foodTypeList = foodTypeList;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
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
