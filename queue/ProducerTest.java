package activimq.queue;

import javax.jms.JMSException;

/**
 * 
* @ClassName: ProducerTest
* @Description: 生产者实例
* @author wangfali
* @date 2017年6月29日 下午12:55:42
*
 */
public class ProducerTest {
	public static void main(String[] args) throws JMSException, Exception {
		ProductorTool productorTool = new ProductorTool();
		productorTool.produceMessage("hello wrold");
		productorTool.close();
	}
}
