package com.briup.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.NonWritableChannelException;

/**
 * 
 * @ClassName: Demo12
 * @Description:
 * @author wangfali
 * @date 2017年7月28日 下午3:35:37
 *
 */
public class Demo12 {
	public static void main(String[] args) {
		while (true) {
			try {
				DatagramChannel datagramChannel = DatagramChannel.open();
				datagramChannel.configureBlocking(false);
				DatagramChannel connect = datagramChannel.connect(new InetSocketAddress("127.0.0.1", 8888));
				connect.configureBlocking(false);
				ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
				byteBuffer.clear();
				byteBuffer.put("wanfdsfajsadjfkausufsd".getBytes());
				int send = datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 8888));
				byteBuffer.flip();
				System.out.println(send);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
