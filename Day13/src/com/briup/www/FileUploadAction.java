package com.briup.www;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传的组件的使用
 * @author wangfali
 *@version 1.0
 *@date 2017年1月20日
 */
public class FileUploadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//获取文件上传的表单
	private File file1;
	//获取文件名
	private String file1FileName;
	//获取文件上传的类型
	private String file1ContentType;
	//文件名变量的set构造器
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	//文件上传类型的set构造器
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	//文件上传表单的set构造器
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	//文件上传执行的方法
	@Override
	public String execute() throws Exception {
		//获取文件上传的工作路径
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		//获取文件名
		File destFile=new File(path,file1FileName);
		//使用文件工具
		FileUtils.copyFile(file1, destFile);
		//打印上传文件的类型
		System.out.println(file1ContentType);
		//返回值
		return SUCCESS;
	}
}
