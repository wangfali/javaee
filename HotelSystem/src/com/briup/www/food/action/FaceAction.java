package com.briup.www.food.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.briup.www.food.service.IFoodTypeService;
import com.briup.www.food.service.IIncomeService;
import com.opensymphony.xwork2.ActionSupport;

/**  
 * @ClassName: FaceAction  
 * @Description: 用于页面集成  
 * @author wangfali
 * @date 2017年4月2日  
 * @version V1.0  
 */
public class FaceAction extends ActionSupport{
	@Resource
	private IFoodTypeService iFoodTypeService;
	@Resource
	private IIncomeService iIncomeService;
	private static final long serialVersionUID = 1L;
	private Map<String,Object> analyseMap;
	public String preface()throws Exception{
		return "preface";
	}
	//菜品和菜系的分析
	public String analyse() throws Exception{
		analyseMap=new HashMap<String, Object>();
		analyseMap.put("chartData",iFoodTypeService.getAnalyse());
		
		return SUCCESS;
	}
	//获取数据分析
	public Map<String, Object> getAnalyseMap() {
		return analyseMap;
	}
	//年度收入分析
	public String analyseIncome() throws Exception{
		analyseMap=new HashMap<String, Object>();
		analyseMap.put("chartData",iIncomeService.getSumary());
		return SUCCESS;
	}
	//年度定桌量的分析
	public String analyseBoard() throws Exception{
		analyseMap=new HashMap<String, Object>();
		analyseMap.put("chartData",iIncomeService.getBoardSumary());
		return SUCCESS;
	}
	//年度客流量分析
	public String analyseCustmer()throws Exception{
		analyseMap=new HashMap<String, Object>();
		analyseMap.put("chartData",iIncomeService.getCustmer());
		return SUCCESS;
	}
}
