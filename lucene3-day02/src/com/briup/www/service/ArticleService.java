package com.briup.www.service;
/**
 * 
* @ClassName: ArticleService
* @Description: 业务层
* @author wangfali
* @date 2017年5月28日 上午10:04:00
*
 */

import com.briup.www.dao.ArticleDao;
import com.briup.www.entity.Page;

public class ArticleService {
	//持久层
	private ArticleDao articleDao=new ArticleDao();
	/**
	 * 
	* @Title: show
	* @Description: 进行分页查询
	* @param @param keywords
	* @param @param currPageNo
	* @param @return
	* @param @throws Exception    
	* @return Page   
	* @throws
	 */
	public Page show(String keywords,int currPageNo)throws Exception{
		//创建一个分页对象
		Page page = new Page();
		//封装当前页号
		page.setCurrPageNo(currPageNo);
		//封装总记录数
		int allRecordeNo = articleDao.getAllRecorde(keywords);
		page.setAllRecordNo(allRecordeNo);
		//封装总页数
		int allPageNo=0;
		if(page.getAllRecordNo()%page.getPerPageSize()==0){
			allPageNo=page.getAllRecordNo()/page.getPerPageSize();
		}else{
			allPageNo=page.getAllRecordNo()/page.getPerPageSize()+1;
		}
		page.setAllPageNo(allPageNo);
		//封装内容
		int size=page.getPerPageSize();
		int start=(currPageNo-1)*size;
		page.setArticles(articleDao.findAll(start, size, keywords));
		return page;
	}
}
