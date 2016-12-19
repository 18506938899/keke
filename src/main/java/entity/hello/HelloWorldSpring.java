package entity.hello;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sk on 2016/11/22.
 */
public class HelloWorldSpring {

    private String name;

    private int age;

    private List<String> names;

    private Map<String,Integer> nameAge;

    private Map<String,String> nameGender;

    private Set<String> sets;

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setNameGender(Map<String, String> nameGender) {
        this.nameGender = nameGender;
    }

    public void setNameAge(Map<String, Integer> nameAge) {
        this.nameAge = nameAge;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

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
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i)+",");
        }
        System.out.println(nameAge.get("keke"));
        System.out.println(nameGender.get("keke"));
        Iterator<String> its = sets.iterator();
        System.out.println(its.next());
    }

    public HelloWorldSpring(String name,HelloWorldMybatis helloWorldMybatis) {
        this.name = name;
        this.helloWorldMybatis=helloWorldMybatis;
    }
}
