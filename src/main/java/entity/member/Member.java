package entity.member;

import entity.info.Info;

/**
 * Created by sk on 2016/11/23.
 */
public class Member {
    private String id;
    private String username;
    private String name;
    private Integer gender;
    private String password;
    private Info info;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    //    /**
//     * 在java中向一个pojo类设置属性值,可以不需要一个一个setPojo类的属性,可以在该pojo类中,
//     * 写一个方法,名称与类名相同,无返回类型(也没有void),把需要设置的属性带进去,在方法体内赋值.
//     *  如果一个类中自定义了一个有参的构造函数,就会覆盖掉系统默认的无参构造函数,
//     *  当需要创建对象时候,就会报错,所以自己在类中必须要再定义一个无参构造函数.
//     * @param id
//     * @param username
//     * @param name
//     * @param password
//     * @param gender
//     */
    public Member (){}

    //改带参构造函数会覆盖掉无参构造函数,造成初始化对象报错,所以自己要重写无参构造函数
    public  Member(String id,String username,String name,String password,
    Integer gender){
        this.id=id;
        this.username=username;
        this.name=name;
        this.gender=gender;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
