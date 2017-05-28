package com.briup.www.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import com.briup.www.entity.Article;
import com.briup.www.util.LuceneUtil;

/**
 * 
 * @ClassName: ArticleDao
 * @Description: 持久层
 * @author wangfali
 * @date 2017年5月27日 下午3:12:38
 *
 */
public class ArticleDao {
	/**
	 * 
	 * @Title: getAllRecorde @Description: 获取总记录数 @param @param
	 * keywords @param @return @param @throws Exception @return int @throws
	 */
	public int getAllRecorde(String keywords) throws Exception {
		// 创建查询器
		QueryParser queryParser = new QueryParser(Version.LUCENE_30, "content", LuceneUtil.getAnalyzer());
		// 查询选择器
		Query query = queryParser.parse(keywords);
		// 创建查询对象
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		// 查询
		TopDocs topDocs = indexSearcher.search(query, 100);
		// 获取总的查询记录数，不被100所影响
		int totalHits = topDocs.totalHits;
		// 关闭资源
		indexSearcher.close();
		// 返回总记录数
		return totalHits;
	}

	/**
	 * 
	 * @Title: findAll @Description: 通过关键字分页查询 @param @param start @param @param
	 * size @param @param keywords @param @return @param @throws
	 * Exception @return List<Article> @throws
	 */
	public List<Article> findAll(int start, int size, String keywords) throws Exception {
		// 创建返回的集合
		List<Article> articles = new ArrayList<Article>();
		// 创建查询器
		QueryParser queryParser = new QueryParser(Version.LUCENE_30, "content", LuceneUtil.getAnalyzer());
		// 查询器中放入查询主键
		Query query = queryParser.parse(keywords);
		// 创建查询
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		// 查询
		TopDocs topDocs = indexSearcher.search(query, 100);
		// 或取查询中的最小值
		int middle = Math.min(start + size, topDocs.totalHits);
		// 迭代
		for (int i = 0; i < middle; i++) {
			// 查询分数
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			// 序号
			int no = scoreDoc.doc;
			// 查询内容
			Document document = indexSearcher.doc(no);
			// 查询出文本
			Article article = (Article) LuceneUtil.document2javabean(document, Article.class);
			// 添加到集合当中
			articles.add(article);
		}
		// 关闭资源
		indexSearcher.close();
		// 返回集合
		return articles;
	}
	/**
	 * 
	* @Title: add
	* @Description: 普通添加文本索引
	* @param @param article
	* @param @throws Exception    
	* @return void   
	* @throws
	 */
	public void add(Article article)throws Exception{
		Document document = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(),LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(document);
		indexWriter.close();
	}
	/**
	 * 
	* @Title: addType
	* @Description: 以文本合并的方式，以二进制的方式进行压缩，解决数量和大小的问题
	* @param @param article
	* @param @throws Exception    
	* @return void   
	* @throws
	 */
	public void addType1(Article article)throws Exception{
		Document document = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(),LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(document);
		//合并文本
		indexWriter.optimize();
		indexWriter.close();
	}
	/**
	 * 
	* @Title: addType2
	* @Description: 设置合并因子 默认情况下是满足10个文件即合并
	* @param @param article
	* @param @throws Exception    
	* @return void   
	* @throws
	 */
	public void addType2(Article article)throws Exception{
		Document document = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(document);
		//设置合并因子 满足3个cfg文件即合并成一个
		indexWriter.setMergeFactor(3);
		indexWriter.close();
	}
	/**】
	 * 
	* @Title: addType3
	* @Description: 创建内存索引库
	* @param @param article
	* @param @throws Exception    
	* @return void   
	* @throws
	 */
	public void addType3(Article article)throws Exception{
		Document document = LuceneUtil.javabean2document(article);
		//硬盘索引库
		FSDirectory directory = FSDirectory.open(new File("E://indexDB"));
		//内存索引库 硬盘索引库的内容要备份到内存索引库
		RAMDirectory ramDirectory = new RAMDirectory(directory);
		/**指向硬盘索引库的字符流，true表示如果内存索引库中和硬盘索引库中的document对象相同时
			先删除硬盘索引库中的document对象
			默认为flase
		*/
		//指向硬盘中的索引字符流
		IndexWriter fsindexWriter = new IndexWriter(directory, LuceneUtil.getAnalyzer(),true, LuceneUtil.getMaxFieldLength());
		//指向内存中的索引字符流
		IndexWriter armindexWriter = new IndexWriter(ramDirectory, LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
		//将document对象写入内存索引库当中
		armindexWriter.addDocument(document);
		armindexWriter.close();
		//将内存索引库所有的document对象同步到硬盘索引库当中
		fsindexWriter.addIndexesNoOptimize(ramDirectory);
		fsindexWriter.close();
	}
	/**
	 * 
	* @Title: findAll
	* @Description: 使用关键字高亮查询
	* @param @throws Exception    
	* @return void   
	* @throws
	 */
	@Test
	public void findAll()throws Exception{
		//配置关键字
		String keywords="培训";
		//设置集合对象
		List<Article>articles=new ArrayList<Article>();
		//配置查询器
		QueryParser queryParser = new QueryParser(Version.LUCENE_30,"content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keywords);
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs topDocs = indexSearcher.search(query, 100);
		//以下代码对内容中含有关键字的字符串高亮显示
		//格式对象
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");
		//关键字对象
		QueryScorer scorer = new QueryScorer(query);
		//高亮对象
		Highlighter highlighter = new Highlighter(formatter, scorer);
		//遍历
		for(int i=0;i<topDocs.scoreDocs.length;i++){
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			int no = scoreDoc.doc;
			//关键字没有高亮
			Document document = indexSearcher.doc(no);
			//关键字高亮
			String titlehighlighter = highlighter.getBestFragment(LuceneUtil.getAnalyzer(),"title",document.get("title"));
			String contenthighlighter = highlighter.getBestFragment(LuceneUtil.getAnalyzer(),"content",document.get("content"));
			//将高亮后的结果再次封装到document对象当中
			document.getField("title").setValue(titlehighlighter);
			document.getField("content").setValue(contenthighlighter);
			Article article = (Article)LuceneUtil.document2javabean(document, Article.class);
			articles.add(article);
		}
		indexSearcher.close();
		for (Article article : articles) {
			System.out.println(article);
		}
	}
}
