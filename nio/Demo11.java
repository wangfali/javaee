package com.briup.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/**
 * 
* @ClassName: Demo11
* @Description: SocketChannel的使用方法
* @author wangfali
* @date 2017年7月28日 下午2:18:04
*
 */
public class Demo11 {
	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			boolean connect = socketChannel.connect(new InetSocketAddress("192.168.19.2", 80));
			ByteBuffer allocate = ByteBuffer.allocate(1024);
			
			System.out.println(connect);
			socketChannel.close();//关闭连接
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
