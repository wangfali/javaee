package com.briup.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

public class Demo14 {
	public static void main(String[] args) {
		try {
			//创建管道
			Pipe pipe = Pipe.open();
			//
			SinkChannel sinkChannel = pipe.sink();
			//
			String newData="new String to write to file "+System.currentTimeMillis();
			ByteBuffer byteBuffer = ByteBuffer.allocate(128);
			byteBuffer.clear();
			byteBuffer.put(newData.getBytes());
			byteBuffer.flip();
			while(byteBuffer.hasRemaining()){
				sinkChannel.write(byteBuffer);
			}
			SourceChannel sourceChannel = pipe.source();
			ByteBuffer dsts=ByteBuffer.allocate(128);
			sourceChannel.read(dsts);
			System.out.println(new String(dsts.array()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
