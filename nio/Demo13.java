package com.briup.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Demo13 {
	public static void main(String[] args) {
		while (true) {
			try {
				DatagramChannel datagramChannel = DatagramChannel.open();
				DatagramChannel connect = datagramChannel.connect(new InetSocketAddress("127.0.0.1", 8888));

				// datagramChannel.socket().bind(new
				// InetSocketAddress("127.0.0.1", 8888));
				datagramChannel.configureBlocking(false);
				ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
				connect.read(byteBuffer);
				byte[] array = byteBuffer.array();
				System.out.println(new String(array));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
