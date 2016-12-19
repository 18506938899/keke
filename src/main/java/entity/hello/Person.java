package entity.hello;

/**
 * Created by sk on 2016/12/19.
 */
public class Person {
    private Person() {
    }

    public static class test{
        static Person person=new Person();
    }
    public static Person getInstance(){
        return test.person;
    }
}
