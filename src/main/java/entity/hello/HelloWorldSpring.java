package entity.hello;

/**
 * Created by sk on 2016/11/22.
 */
public class HelloWorldSpring {

    private String name;

    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    private HelloWorldMybatis helloWorldMybatis;

    public void hello() {
        helloWorldMybatis.recite();
        System.out.println("hello" +" "+name);
    }

    public HelloWorldSpring(String name,HelloWorldMybatis helloWorldMybatis) {
        this.name = name;
        this.helloWorldMybatis=helloWorldMybatis;
    }
}
