package activimq.queue;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
* @ClassName: ConsumerTool
* @Description: 消费者 实现jms 中的消息监听、异常监听
* @author wangfali
* @date 2017年6月28日 下午8:34:08
* 
 */
public class ConsumerTool implements MessageListener,ExceptionListener{
	//默认消息队列的用户
	private String user=ActiveMQConnection.DEFAULT_USER;
	//默认消息队列的密码
	private String password=ActiveMQConnection.DEFAULT_PASSWORD;
	//默认消息队列的url
	private String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	//上传消息的类别
	private String subject="myqueue";
	private Destination destination=null;
	private Connection connection=null;
	private Session session=null;
	private MessageConsumer consumer=null;
	private ActiveMQConnectionFactory connectionFactory=null;
	public static Boolean isconnection=false;
	/**
	 * 初始化消费者连接信息
	 */
	private void initialize()throws JMSException{
		//初始化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(user, password, url);
		//初始化连接
		connection=connectionFactory.createConnection();
		//初始化会话
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination=session.createQueue(subject);
		consumer=session.createConsumer(destination);
	}
	/**
	 * 消费信息
	 */
	public void consumeMessage()throws JMSException{
		//初始化成员变量
		initialize();
		//打开和消息队列服务器之间的连接
		connection.start();
		//将当前消费者加入消息监听
		consumer.setMessageListener(this);
		//将当前连接加入异常监听
		connection.setExceptionListener(this);
		System.out.println("consumer:->begin listening-----");
		isconnection=true;
		//开始监听
		Message message = consumer.receive();
		System.out.println(message.getJMSMessageID());
	}
	/**
	 * 关闭连接
	 */
	public void close() throws JMSException{
		System.out.println("consumer->closing connection");
		if(consumer!=null){
			consumer.close();
		}
		if(session!=null){
			session.close();
		}
		if(connection!=null){
			connection.close();
		}
		
	}
	public void onException(JMSException exception) {
			//如果发生错误，当前连接会断开
		isconnection=false;
	}
	/**
	 * 消息处理函数
	 */
	public void onMessage(Message message) {
		try {
			//判断当前的消息是否为文本类型的消息
			if(message instanceof TextMessage){
				TextMessage textMessage=(TextMessage) message;
				String msg=textMessage.getText();
				System.out.println("消费者获取到的信息"+msg);
			}else{
				System.out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
