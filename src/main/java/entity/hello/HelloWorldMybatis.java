package entity.hello;

import entity.inter.Hello;

/**
 * Created by sk on 2016/12/19.
 */
public class HelloWorldMybatis implements Hello {
    public void recite() {
        System.out.println("我实现了hello接口");
    }
}
