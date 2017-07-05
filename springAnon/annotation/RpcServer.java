package springOrder.springAnon.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by samsung on 2017/7/4.
 * spring自定义注解类
 *
 */
@Target(ElementType.TYPE)//标签的类型，
@Retention(RetentionPolicy.RUNTIME)//标签的作用域
@Component
public @interface RpcServer {
    String value() default "";
}
