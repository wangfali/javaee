package com.briup.www.exception;
/**
 * 菜系名称已经存在
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
public class TypeNameExistException extends Exception{
	private static final long serialVersionUID = 1L;
	public TypeNameExistException(String msg){
		super(msg);
	}
}
