package com.briup.www.util;
/**
* @ClassName: LuceneUtil
* @Description: lucene工具类
* @author wangfali
* @date 2017年5月27日 下午2:30:39
*
 */

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneUtil {
	private static Directory directory;
	private static Version version;
	private static MaxFieldLength maxFieldLength;
	private static Analyzer analyzer;
	static {
		try {
			directory = FSDirectory.open(new File("E://indexDB11"));
			version = Version.LUCENE_30;
			maxFieldLength = MaxFieldLength.LIMITED;
			analyzer = new StandardAnalyzer(version);
			//analyzer = new IKAnalyzer();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 不让外界创建该类
	private LuceneUtil() {
	}

	public static Directory getDirectory() {
		return directory;
	}

	public static void setDirectory(Directory directory) {
		LuceneUtil.directory = directory;
	}

	public static Version getVersion() {
		return version;
	}

	public static void setVersion(Version version) {
		LuceneUtil.version = version;
	}

	public static MaxFieldLength getMaxFieldLength() {
		return maxFieldLength;
	}

	public static void setMaxFieldLength(MaxFieldLength maxFieldLength) {
		LuceneUtil.maxFieldLength = maxFieldLength;
	}

	public static Analyzer getAnalyzer() {
		return analyzer;
	}

	public static void setAnalyzer(Analyzer analyzer) {
		LuceneUtil.analyzer = analyzer;
	}

	// 将javabean对象转换成document对象
	public static Document javabean2document(Object obj) throws Exception {
		// 创建document对象
		Document document = new Document();
		// 获取对象的字节码
		@SuppressWarnings("rawtypes")
		Class clazz = obj.getClass();
		// 获取对象的私有属性
		Field[] declaredFields = clazz.getDeclaredFields();
		// 迭代私有属性
		for (Field field : declaredFields) {
			// 暴力反射
			field.setAccessible(true);
			// 获取名称
			String name = field.getName();
			// 人工拼接方法
			String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1).toString();
			// 获取方法
			@SuppressWarnings("unchecked")
			Method method = clazz.getMethod(methodName);
			// 执行获取后的方法
			String value = method.invoke(obj).toString();
			// 进行封装
			document.add(new org.apache.lucene.document.Field(name, value, Store.YES, Index.ANALYZED));
		}
		// 返回document对象
		return document;
	}

	// 将document对象转换为javabean对象
	@SuppressWarnings("rawtypes")
	public static Object document2javabean(Document document, Class clazz) throws Exception {
		// 通过字节码创建一个对象
		Object object = clazz.newInstance();
		// 获取是有属性
		Field[] declaredFields = clazz.getDeclaredFields();
		// 迭代私有属性
		for (Field field : declaredFields) {
			// 暴力反射
			field.setAccessible(true);
			// 获取属性名称
			String name = field.getName();
			// 获取私有属性的值
			String value = document.get(name);
			// 进行对象的封装
			BeanUtils.setProperty(object, name, value);
		}
		// 返回对象
		return object;
	}

}
