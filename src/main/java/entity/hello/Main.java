package entity.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sk on 2016/11/22.
 */
public class Main {
    public static void main(String[] args) {
        //传统方法
        //创建HelloWorldSpring对象
//        HelloWorldSpring helloWorldSpring = new HelloWorldSpring();
        //为属性name复制
//        helloWorldSpring.setName("zsk");
        //调用hello()方法

//        spring方法
        //创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

        HelloWorldSpring helloWorldSpring = (HelloWorldSpring) applicationContext.getBean("helloWorldSpring");

        helloWorldSpring.hello();
    }
}
