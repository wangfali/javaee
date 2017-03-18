package com.briup.web.Dao;

import java.util.List;

import com.briup.web.Bean.person;

public interface DaoInterface {
	public boolean addContact(person p);//添加联系人
	public boolean updateContact(person p);//更新联系人
	public boolean deleteContact(String id);//删除联系人
	public List<person>fillAll();//查询所有联系人返回值为一个集合
	public person findById(String id);//返回的是一个对象
}
