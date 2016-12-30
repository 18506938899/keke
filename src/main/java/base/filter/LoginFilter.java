package base.filter;

import com.study.service.MemberService;
import entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sk on 2016/12/26.
 */
public class LoginFilter implements Filter {

    @Autowired(required = false)
    private MemberService memberService;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response,

                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        //从请求中获取cookie,获取到的是一个cookie数组
        Cookie[] cookie = req.getCookies();
        String[] cooks = null;
        String username = "";
        String password = "";
        //遍历cookie,获取验证登录的cookie
        for (Cookie cc : cookie) {
            if ("autoLogin".equals(cc.getName())) {
                String aa = cc.getValue();
                cooks = aa.split("==");
                username = cooks[0];
                password = cooks[1];
            }
        }

        Member member = memberService.getMemberByUsername(username);
        if (password.equals(member.getPassword())) {
            rep.sendRedirect("/success");
        } else {
            req.getRequestDispatcher("/fail").forward(request, response);
        }
    }

    public void destroy() {

    }
}
