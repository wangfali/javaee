package com.briup.www.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
public class Test2Excel {

	/*@Test
	public void test() throws Exception {
		//创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个表
		HSSFSheet sheet = workbook.createSheet();
		//创建行
		HSSFRow row = sheet.createRow(3);
		//创建单元格
		HSSFCell cell = row.createCell(3);
		//填写单元格的内容
		cell.setCellValue("Hello work!");
		//创建文件输出流
		FileOutputStream fileOutputStream = new FileOutputStream("E://work.xls");
		//输出工作簿
		workbook.write(fileOutputStream);
		//关闭文件输出流
		fileOutputStream.close();
		//关闭工作簿
		workbook.close();
		
	}*/
	/*@Test
	public void testReadExcel() throws Exception{
		//创建一个文件输入流
		FileInputStream stream = new FileInputStream("E://work.xls");
		//创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		//读取表格
		HSSFSheet sheet = workbook.getSheetAt(0);
		//读取行
		HSSFRow row = sheet.getRow(3);
		//读取单元格
		HSSFCell cell = row.getCell(3);
		//输出单元格
		String value = cell.getStringCellValue();
		System.out.println(value);
		//关闭工作簿
		workbook.close();
		//关闭输入流
		stream.close();
	}*/
/*	@Test
	public void test2Write07Excel() throws Exception{
		//创建单元格
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建表格
		XSSFSheet sheet = workbook.createSheet();
		//创建行
		XSSFRow row = sheet.createRow(3);
		//创建单元格
		XSSFCell cell = row.createCell(3);
		//单元格内写入文本信息
		cell.setCellValue("Hello World!");
		//创建文件输出流
		FileOutputStream stream = new FileOutputStream("E://work22.xlsx");
		//将工作簿输出
		workbook.write(stream);
		//关闭工作簿
		workbook.close();
		//关闭文件输出流
		stream.close();
	}*/
	/*@Test
	public void test2Read07Excel() throws Exception{
		//创建文件输入流
		FileInputStream inputStream = new FileInputStream("E://work22.xlsx");
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		//查询表
		XSSFSheet sheet = workbook.getSheetAt(0);
		//查询表中的行
		XSSFRow row = sheet.getRow(3);
		//查询行中的单元格
		XSSFCell cell = row.getCell(3);
		//查询单元格中的内容
		String value = cell.getStringCellValue();
		//输出表中的内容
		System.out.println(value);
		//关闭工作簿
		workbook.close();
		//关闭输入流
		inputStream.close();
	}*/
	/*@Test
	public void test2ReadAllExcl() throws Exception{
		
		//解析不同版本的excel
		String fileName="E://work22.xlsx";
		//判断是否为Excel文档
		if(fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
			//判断是否为03版本的excell
			boolean is03Excel=fileName.matches("^.+\\.(?i)(xls)$");
			//创建文件输入流
			FileInputStream inputStream = new FileInputStream(fileName);
			//使用不同的解析核心类
			Workbook workbook=is03Excel?new HSSFWorkbook(inputStream):new XSSFWorkbook(inputStream);
			//获取表对象
			Sheet sheet = workbook.getSheetAt(0);
			//获取行对象
			Row row = sheet.getRow(3);
			//获取单元格对象
			Cell cell = row.getCell(3);
			//从单元格中获取内容
			String value = cell.getStringCellValue();
			//输出内容
			System.out.println(value);
			//关闭流
			inputStream.close();
			//关闭工作簿
			workbook.close();
		}
	}*/
	@Test
	public void testStlyeForExcel() throws Exception{
		//使用样式对excel文档的样式进行加工
		//合并单元格
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建单元格合并样式 合并第三行的第三列到第五列
		CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 2, 2, 4);
		//创建单元格样式
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		//文本水平居中
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		//文本垂直居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		//创建字体---------------------------------------
		XSSFFont font = workbook.createFont();
		//字体加粗
		font.setBold(true);
		//字体字号
		font.setFontHeightInPoints((short)23);
		//样式加载字体
		cellStyle.setFont(font);
		//创建单元格背景-----------------------------------
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//设置背景颜色
		cellStyle.setFillBackgroundColor(HSSFColor.DARK_YELLOW.index);
		//设置填充前景色
		cellStyle.setFillForegroundColor(HSSFColor.RED.index);
		//创建表格
		XSSFSheet sheet = workbook.createSheet("first");
		//加载合并单元格
		sheet.addMergedRegion(cellRangeAddress);
		//创建行 创建第三行
		XSSFRow row = sheet.createRow(2);
		//创建单元格 创建第三列
		XSSFCell cell = row.createCell(2);
		//加载样式
		cell.setCellStyle(cellStyle);
		//单元格内写入内容
		cell.setCellValue("hello world!");
		//创建输出流
		FileOutputStream outputStream = new FileOutputStream("E:wangfali.xlsx");
		//将工作簿输出
		workbook.write(outputStream);
		//关闭流
		outputStream.close();
		//关闭工作簿
		workbook.close();
	}
}
