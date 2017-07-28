package com.briup.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Demo9 {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		FileChannel channel = null;
		FileChannel channel2 = null;
		try {
			fileInputStream = new FileInputStream(new File("D:/十年.txt"));
			fileOutputStream = new FileOutputStream(new File("E:/十年.txt"));
			channel = fileInputStream.getChannel();
			channel2 = fileOutputStream.getChannel();
			/**
			 * @src 数据源管道
			 * @param position
			 *            文件的传输中的位置开始,必须是非负数
			 * @param count
			 *            被转移的最大字节数;必须是非负数（注意如果数据小于count，将会出现覆盖的问题）
			 */
			channel.transferTo(0, channel.size(), channel2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				channel2.close();
				channel.close();
				fileOutputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
