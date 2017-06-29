package activimq.queue;

/**
 * 
* @ClassName: ConmerTest
* @Description: 使用消息队列
* @author wangfali
* @date 2017年6月28日 下午8:32:09
*
 */
public class ConmerTest implements Runnable{
	public static Thread t1=null;
	public static void main(String[] args)throws Exception {
		//创建一个新的线程
		t1=new Thread(new ConmerTest());
		//开启线程
		t1.start();
		while(true){
			System.out.println(t1.isAlive());
			//如果线程发生异常堵塞，则重新开始一个新的线程
			if(!t1.isAlive()){
				t1=new Thread(new ConmerTest());
				t1.start();
				System.out.println("重新启动");
			}
			Thread.sleep(5000);
		}
	}
	public void run() {
		try {
			//创建一个新的消费者对象
			ConsumerTool consumerTool = new ConsumerTool();
			//消费信息
			consumerTool.consumeMessage();
			while(ConsumerTool.isconnection){
				System.out.println("123");
			}
		} catch (Exception e) {
		}
	}

}
