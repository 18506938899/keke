package entity.hello;

/**
 * Created by sk on 2016/11/22.
 */
public class HelloWorldSpring {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello" +" "+name);
    }
}
