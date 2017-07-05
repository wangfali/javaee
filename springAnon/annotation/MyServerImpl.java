package springOrder.springAnon.annotation;

/**
 * Created by samsung on 2017/7/4.
 * 实现业务层的方法
 */
@RpcServer(value = "ServerImpl")
public class MyServerImpl implements MyServer {
    public String hello(String hello) {
        return hello;
    }
}
