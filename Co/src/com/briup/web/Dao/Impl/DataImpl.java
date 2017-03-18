package com.briup.web.Dao.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.briup.web.Bean.person;
import com.briup.web.Dao.DaoInterface;
import com.briup.web.Util.XMLUtil;

/**
 * 数据操作的实现类
 * @author wangfali
 * @version 1.0
 */
public class DataImpl implements DaoInterface{
	/**
	 * 添加对象
	 * @param p 
	 */
	@Override
	public boolean addContact(person p) {
	try{
		File file=new File("e:/Contact.xml");
		Document document=null;
		Element element=null;
		if(!file.exists()){
			file.createNewFile();
			document=DocumentHelper.createDocument();
			element = document.addElement("ContactList");
		}else{
			document = XMLUtil.getDocument();
			element = document.getRootElement();
		}
			//由系统自动生成id进行存储
			String uuid = UUID.randomUUID().toString().replace('_', ' ');
			Element addElement = element.addElement("Contact");
			addElement.addAttribute("id",uuid);
			addElement.addAttribute("name", p.getNameString());
			addElement.addAttribute("qq", p.getqQString());
			addElement.addAttribute("email", p.getEmailString());
			addElement.addAttribute("phone", p.getPhoneString());
			XMLUtil.writeXml(document);
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
		
	}
	/**
	 * 更新文件
	 */
	@Override
	public boolean updateContact(person p) {
		//将文件读取到内存中
		Document document = XMLUtil.getDocument();
		Element rootElement = document.getRootElement();
		//在文件中找到要修改的对象
		Element node = (Element) rootElement.selectSingleNode("//Contact[@id='"+p.getIdString()+"']");
		System.out.println(node);
		//判断该对象是否找到
		if(node!=null){
			node.addAttribute("name",p.getNameString());
			node.addAttribute("phone", p.getPhoneString());
			node.addAttribute("qq", p.getqQString());
			node.addAttribute("email", p.getEmailString());
			XMLUtil.writeXml(document);
			return true;
		}
		return false;
	}
	/**
	 * 删除文件
	 */
	@Override
	public boolean deleteContact(String id) {
		//将文件读取到内存中
		Document document = XMLUtil.getDocument();
		Element rootElement = document.getRootElement();
		Element node = (Element)rootElement.selectSingleNode("//Contact[@id='"+id+"']");
		if(node!=null){
			node.detach();
		XMLUtil.writeXml(document);
		return true;
		}else{
			return false;
		}
	}
/**
 *查找所有的对象
 */
	@Override
	public List<person> fillAll() {
		//先定义一个集合用于存储返回的对象
		List<person>list=new ArrayList<person>();
		//将文件读取到内存中
		Document document = XMLUtil.getDocument();
		//查找文件中所有的对象
		Element rootElement = document.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> nodes =(List<Element>)rootElement.selectNodes("//Contact");
		for (Element element : nodes) {
			person person = new person();
			person.setIdString(element.attributeValue("id"));
			person.setEmailString(element.attributeValue("email"));
			person.setNameString(element.attributeValue("name"));
			person.setPhoneString(element.attributeValue("phone"));
			person.setqQString(element.attributeValue("qq"));
			list.add(person);
		}
		return list;
	}
	/**
	 * 通过Id查找对象
	 */
	@Override
	public person findById(String id) {
		//将文件读取到内存中
		Document document = XMLUtil.getDocument();
		//通过id查找对象
		Element rootElement = document.getRootElement();
		Element node = (Element)rootElement.selectSingleNode("//Contact[@id='"+id+"']");
		//判断是否可以找到对象
		if(node!=null){
			person person = new person();
			person.setEmailString(node.attributeValue("email"));
			person.setIdString(node.attributeValue("id"));
			person.setNameString(node.attributeValue("name"));
			person.setPhoneString(node.attributeValue("phone"));
			person.setqQString(node.attributeValue("qq"));
			return person;
		}
		return null;
	}

	
	}
	

