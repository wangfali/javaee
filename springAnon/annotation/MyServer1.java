package springOrder.springAnon.annotation;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by samsung on 2017/7/4.
 * 测试rpcserver注解
 */
@Component //ApplicationContextAware会被Component组件调用setApplicationContext方法；
public class MyServer1 implements ApplicationContextAware{
    public static void main(String[] args){
        //程序启动，加载配置文件
      new ClassPathXmlApplicationContext("spring2.xml");
    }

    /**
     *
     * @param applicationContext 应用的上下文
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> map = applicationContext.getBeansWithAnnotation(RpcServer.class);
        //遍历map集合
        try {
        for (Object object : map.values()) {
                //获取自定义注解上的value
            String value = object.getClass().getAnnotation(RpcServer.class).value();
            System.out.println( "注解上的value:"+value);
            //反射被注解类，并调用指定方法
            Method method = object.getClass().getMethod("hello", String.class);
            Object invoke = method.invoke(object, "eee");
            System.out.println( invoke);

        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
