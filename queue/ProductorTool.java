package activimq.queue;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
* @ClassName: ProductorTool
* @Description: 生产者工具
* @author wangfali
* @date 2017年6月28日 下午9:33:55
*
 */
public class ProductorTool{
	//注册生产者的信息
	private String user=ActiveMQConnection.DEFAULT_USER;
	//注册生产者url
	private String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	//注册生产者的密码
	private String password=ActiveMQConnection.DEFAULT_PASSWORD;
	//注册消息队列类型
	private String subject="myqueue";
	private ActiveMQConnectionFactory connectionFactory=null;
	private Destination destination=null;
	private Connection connection=null;
	private Session session=null;
	private MessageProducer producer=null;
	//初始化
	public void initialize()throws JMSException{
		//初始化连接工厂
		connectionFactory= new ActiveMQConnectionFactory(user, password, url);
		//创建连接
		connection=connectionFactory.createConnection();
		//创建连接会话
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建消息对列
		destination = session.createQueue(subject);
		//通过会话创建生产者
		producer=session.createProducer(destination);
		//
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	}
	//发送消息
	public void produceMessage(String message)throws JMSException,Exception{
		//初始化参数
		initialize();
		//创建消息
		TextMessage textMessage = session.createTextMessage(message);
		//连接开始
		connection.start();
		System.out.println("producer:->Sending message"+message);
		//生产者生产消息
		producer.send(textMessage);
		System.out.println("producer->mesage send complete");
		
	}
	//关闭连接
	public void close()throws Exception{
		System.out.println("producer->close connection");
		if(producer!=null){
			producer.close();
		}
		if(session!=null){
			session.close();
		}
		if(connection!=null){
			connection.close();
		}
	}
}
