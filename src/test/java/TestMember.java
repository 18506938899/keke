import com.alibaba.fastjson.JSON;
import com.study.service.MemberService;
import entity.member.Member;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
    }
}
