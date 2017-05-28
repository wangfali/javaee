package com.briup.www.analyze;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.fr.FrenchAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

/**
 * 
* @ClassName: TestAnalyze
* @Description: 测试常用的分词器
* @author wangfali
* @date 2017年5月27日 下午4:33:49
*
 */
public class TestAnalyze {
	private static void testanalyze(Analyzer analyzer,String text)throws Exception{
		System.out.println("当前使用的分词器"+analyzer.getClass().getSimpleName());
		TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
		tokenStream.addAttribute(TermAttribute.class);
		while (tokenStream.incrementToken()) {
			TermAttribute termAttribute=tokenStream.getAttribute(TermAttribute.class);
			System.out.println(termAttribute.term());
		}
	}
	public static void main(String[] args) throws Exception {
		//testanalyze(new StandardAnalyzer(Version.LUCENE_30), "传智播客说我们的首都是北京呀it");
		testanalyze(new FrenchAnalyzer(Version.LUCENE_30), "传智播客说我们的首都是北京呀it");
	}
}
