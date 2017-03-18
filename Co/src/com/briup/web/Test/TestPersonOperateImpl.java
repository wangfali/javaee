package com.briup.web.Test;


import org.junit.Before;
import org.junit.Test;

import com.briup.web.Bean.person;
import com.briup.web.Dao.DaoInterface;
import com.briup.web.Dao.Impl.DataImpl;

/**
 * 测试数据操作类
 * @author wangfali
 *@version 1.0
 *@date 2016年11月22日
 */
public class TestPersonOperateImpl {
	DaoInterface operate=null;
	@Before 
	public void init(){
		operate=new DataImpl();
	}
	@Test
	public void testAddperson(){
		person person = new person();
		person.setEmailString("www.com@qq.com");
		person.setIdString("2");
		person.setNameString("wangfali");
		person.setPhoneString("22343332");
		person.setqQString("24332");
		operate.addContact(person);
	}
	@Test
	public void updatePerson(){
		person person = new person();
		person.setIdString("1");
		person.setEmailString("1320895332@qq.com");
		person.setNameString("wang");
		person.setPhoneString("18379162422");
		person.setqQString("1320895332");
		operate.updateContact(person);
	}
	@Test
	public void testDeletePerson(){
		boolean state = operate.deleteContact("1");
		System.out.println(state);
	}
	@Test
	public void testFindById(){
		person person = operate.findById("1");
		System.out.println(person);
	}
	@Test
	public void testFindAll(){
		operate.fillAll();
	}
}
