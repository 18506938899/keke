package com.study.controller;

import com.study.service.MemberService;
import entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sk on 2016/11/24.
 */
@Controller
public class AdminMemberController {

    private MemberService memberService;

    @Autowired(required =false)
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public ModelAndView login(String username,String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member member = memberService.getMemberByUsername(username);
        if (password.equals(member.getPassword())) {
            return new ModelAndView("/success", map);
        } else {
            return new ModelAndView("/fail", map);
        }
    }
}
