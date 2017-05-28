package com.briup.www.sort;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopFieldDocs;
import org.apache.lucene.util.Version;
import org.junit.Test;

import com.briup.www.entity.Article;
import com.briup.www.util.LuceneUtil;

/**
 * 
* @ClassName: ArticleDaoSort1
* @Description: lucene相关度搜索排名
* 默认的情况下，lucene是按照相关度的得分排名进行排序
* @author wangfali
* @date 2017年5月27日 下午8:27:03
*
 */
public class ArticleDaoSort1 {
	/**
	 * 增加document对象索引库中
	 */
	public void add()throws Exception{
		Article article = new Article(1, "培训", "传智是一家it培训机构", 10);
		Document document = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), LuceneUtil.getMaxFieldLength());
		//人工设置该document的得分
		document.setBoost(100F);
		indexWriter.addDocument(document);
		indexWriter.close();
		
	}
	/**
	 * 
	* @Title: findAll
	* @Description: 查询通过设置查询相关度的方法排序
	* @param @throws Exception    
	* @return void   
	* @throws
	 */
	
	public void findAll()throws Exception{
		String keywords="培训";
		List<Article>articles=new ArrayList<Article>();
		QueryParser queryParser = new QueryParser(Version.LUCENE_30,"content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keywords);
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs topDocs = indexSearcher.search(query, 100);
		for(int i=0;i<topDocs.scoreDocs.length;i++){
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			int no = scoreDoc.doc;
			//获取document对象的评分
			float score = scoreDoc.score;
			System.out.println("文本对象的评分"+score);
			Document document = indexSearcher.doc(no);
			Article article = (Article)LuceneUtil.document2javabean(document, Article.class);
			articles.add(article);
		}
		indexSearcher.close();
		for (Article article : articles) {
			System.out.println(article);
		}
	}
	/**
	 * 
	* @Title: findAll1
	* @Description: 通过指定的字段进行排序
	* @param @throws Exception    
	* @return void   
	* @throws
	 */
	@Test
	public void findAll1()throws Exception{
		//关键字
		String keywords="培训";
		//定义集合对象
		List<Article>articles= new ArrayList<Article>();
		QueryParser queryParser = new QueryParser(Version.LUCENE_30,"content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keywords);
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		//按得分度高低排序
		//TopDocs topDocs = indexSearcher.search(query, 100);
		//创建排序对象
		/**
		 * 参数一：id表示依据document对象中的那个对象进行排序
		 * 参数二：SortField.INT表示document丢对象当中该字段的类型
		 * 参数三：true表示降序类似于order by id desc
		 * 参数三：false表示升序，类似于order by id asc
		 */
		//sort表示排序的条件
		Sort sort = new Sort(new SortField("count",SortField.INT,true),new SortField("id",SortField.INT, true));
		TopFieldDocs topFieldDocs = indexSearcher.search(query, null, 100, sort);
		for(int i=0;i<topFieldDocs.scoreDocs.length;i++){
			ScoreDoc scoreDoc = topFieldDocs.scoreDocs[i];
			int no = scoreDoc.doc;
			Document document = indexSearcher.doc(no);
			Article article = (Article)LuceneUtil.document2javabean(document, Article.class);
			articles.add(article);
		}
		indexSearcher.close();
		for (Article article : articles) {
			System.out.println(article);
		}
		
	}
}
