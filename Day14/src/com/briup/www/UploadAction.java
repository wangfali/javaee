package com.briup.www;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传类
 * @author wangfali
 *@version 1.0
 *@date 2017年1月21日
 */
public class UploadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//获取表单内容
	private File file1;
	//获取文件名称
	private String file1FileName;
	//提供set构造器
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	@Override
	public String execute() throws Exception {
		//获取文件上传的目录路径
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		//创建一个目标文件
		File destFile=new File(path,file1FileName);
		//使用文件复制
		FileUtils.copyFile(file1, destFile);
		return SUCCESS;
	}
}
