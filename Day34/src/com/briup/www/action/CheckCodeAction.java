package com.briup.www.action;
import java.io.PrintWriter;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 验证码的检查
 * @author wangfali
 *@version 1.0
 *@date 2017年3月11日
 */
public class CheckCodeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//获取用户输入的验证码
	private String checkCode;
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	//验证码验证
	public String checkCode() throws Exception {
		//图片路径
		String img="images/MsgError.gif";
		//从session中获取验证码
		String str = (String) ActionContext.getContext().getSession().get("CHECKNUM");
		//比较验证码是否正确
		if(str.equals(checkCode)){
			//验证码正确
			img="images/MsgSent.gif";
		}else{
			//验证码错误
			img="images/MsgError.gif";
		}
		//使用流输出
		PrintWriter pw = ServletActionContext.getResponse().getWriter();
		pw.write(img);
		pw.flush();
		pw.close();
		return null;
	}
}
