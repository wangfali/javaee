package com.briup.www.food.action;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.briup.www.food.entity.Customer;
import com.briup.www.food.entity.Income;
import com.briup.www.food.service.ICustomerService;
import com.briup.www.food.service.IFoodService;
import com.briup.www.food.service.IIncomeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**  
 * @ClassName: CustomerAction  
 * @Description: 订单操作action  
 * @author wangfali
 * @date 2017年4月4日  
 * @version V1.0  
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	@Resource
	private ICustomerService iCustomerService;
	@Resource
	private IFoodService iFoodService;
	@Resource
	private IIncomeService iIncomeService;
	
	private Customer customer=new Customer();
	private List<Customer>customerList;
	private String count;
	private String money;
	
	//显示所有的订单
	public String dingdan() throws Exception{
		customerList=iCustomerService.getAll();
		return "dingdan";
	}
	//删除订单
	public String delete() throws Exception{
		Income income = new Income();
		income.setMoney(BigDecimal.valueOf(Double.parseDouble(money)));
		income.setMonth(Integer.toString(Calendar.MONTH));
		income.setYear(Integer.toString(Calendar.YEAR));
		iIncomeService.save(income);
		iCustomerService.delete(customer.getId());
		return "list";
	}
	//更新订单
	public String Update() throws Exception{
		iCustomerService.update(customer);
		return "list";
	}
	//保存订单
	public void addCustomer() throws Exception{
		customer.setPrice(Double.parseDouble(count));
		customer.setTime(new Date());
		customer.setState(false);
		String name = customer.getBoardName();
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		customer.setBoardName(name);
		iCustomerService.save(customer);
	}
	
	
	
	
	
	
	
	@Override
	public Customer getModel() {
		return customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	
}
