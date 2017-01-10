import com.alibaba.fastjson.JSON;
import com.study.service.MemberService;
import entity.member.Member;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by sk on 2016/12/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMember {
    private static Logger logger = Logger.getLogger(TestMember.class);

    @Autowired(required = false)
    private MemberService memberService;

    @Test
    public void test1() {
        Member member = memberService.getMemberById("1");
        System.out.println(JSON.toJSONString(member));

        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                if (i > 0) {
                    continue;
                }
            }
            System.out.print(i + "    ");
        }
    }


    @Test
    public void testAssoSelect() {
        Member member = memberService.getMemberByUsername("18506938899");
        System.out.println(member.getInfo().getHobbdy());
    }


    @Test
    public void testCollection() {
        //TODO:set集合的取值与存值
//        Set<String> set = new HashSet<>();
//        set.add("1");
//        set.add("2");
//        set.add("1");
//        System.out.println(set.size());
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        TODO:map集合的存值与取值
//        TODO:HashMap()与HashTable()的区别
//        TODO:hashMap允许一个键为null,多个值为null
//        TODO:hashTable不允许存在为null的键存在,它比hashMap慢,因为他是同步的

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put(null, "4");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(map.get(it.next()));
        }

        Map<String, Object> mapTable = new Hashtable<>();
//        mapTable.put(null,"5");
        Iterator itTable = mapTable.keySet().iterator();
        while (itTable.hasNext()) {
            System.out.println(mapTable.get(it.next()));
        }
    }


    @Test
    public void testMath() {
        double i = -2.5;
        //四舍五入
        System.out.println(Math.round(i));//-2
        //不大于的整数
        System.out.println(Math.floor(i));//-3.0
        //不小于的整数
        System.out.println(Math.ceil(i));//-2.0
    }
}
