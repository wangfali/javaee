package com.briup.web.Util;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml文档的操作工具类
 * @author wangfali
 *
 */
public class XMLUtil {
	/**
	 * 读取xml文档
	 * @return
	 */
	public static Document getDocument(){
		try {
			Document document = new SAXReader().read(new File("e:/Contact.xml"));
			return document;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 将文档写入原文件中
	 * @param doc 
	 */
	public static void writeXml(Document doc){
		try {
			FileOutputStream outputStream=new FileOutputStream(new File("e:/Contact.xml"));
			OutputFormat outputFormat=OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("utf-8");
			XMLWriter writer=new XMLWriter(outputStream, outputFormat);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
