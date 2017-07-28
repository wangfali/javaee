package com.briup.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

public class Demo10 {
	public static void main(String[] args) {
		try {
			AsynchronousServerSocketChannel.open();//nio 2.0 aio
			//创建一个selector对象
			Selector selector = Selector.open();
			//注册管道实现监听
			DatagramChannel channel = DatagramChannel.open();
			channel.configureBlocking(false);//声明为非阻塞
			
			SelectionKey selectionKey = channel.register(selector,SelectionKey.OP_READ);
			int interestSet = selectionKey.interestOps();
			boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
			int readyOps = selectionKey.readyOps();//ready 集合是通道已经准备就绪的操作的集合
			selectionKey.isReadable();//读就绪
			selectionKey.isWritable();//写就绪
			selectionKey.isConnectable();//连接就绪
			selectionKey.isAcceptable();//接收连接就绪
			//从SelectionKey访问Channel和Selector很简单。
			SelectableChannel selectableChannel = selectionKey.channel();
			selectionKey.selector();
			//可以附加 与通道一起使用的Buffer，或是包含聚集数据的某个对象(附加对象)
			selectionKey.attach(ByteBuffer.allocate(128));
			//一旦向Selector注册了一或多个通道，就可以调用几个重载的select()方法
			int select = selector.select();//返回读就绪的通道，但是他会阻塞到有值
			//通过返回就绪的值就可以开始对管道进行操作了
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			for (SelectionKey selectionKey2 : selectedKeys) {
				if(selectionKey2.isAcceptable()){
					
				}
			}
			//某个线程调用select()方法后阻塞了使用wakeup(唤醒)
			selector.close();//关闭监听，但是通道不会关闭
			channel.close();//将通道关闭
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
