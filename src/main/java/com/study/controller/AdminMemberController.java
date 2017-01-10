package com.study.controller;

import com.study.service.MemberService;
import entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sk on 2016/11/24.
 */
@Controller
public class AdminMemberController {

    private MemberService memberService;

    @Autowired(required = false)
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }


    /**
     * springMVC注解@ModelAndAttribute
     * 用法一:使用在方法体上,每当请求一次目标方法时候,被该注解注解的方法都会首先被调用.
     * 如下写法,会返回一个map,key就是member,value就是member对象
     * 在目标方法中通过map.get("member")得到member
     * 用法而:使用在方法的参数前面,springMvc会首先在数据模型中寻找该属性,赋值给后面的参数对象,
     * 并且会覆盖后面参数对象中存在同名的属性值
     */
//    @ModelAttribute("member")
//    public Member sayHelloWorld(){
//        Member member= new Member("","keke","kb24851","",0);
//        return member;
//    }

    /**
     * 用户登录
     *
     * @param request
     * @param username
     * @param password map1 用于介绍被@ModelAndAttribute注解的方法,传递过来的member对象
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response, HttpServletRequest request, String username, String password,
                              Map<String, Member> map1) {
        //获取客户端的ip地址
//        System.out.println(request.getRemoteAddr());
//        //获取请求相对路径
//        String webRealPath = request.getServletPath();
//        //获取web工程的根目录,也就是web目录的地址
//        String webRealPath1 = request.getSession().getServletContext().getRealPath("a");
//        //获取部署的项目的名称
//        String path=request.getContextPath();
        Map<String, Object> map = new HashMap<String, Object>();
        Member member = memberService.getMemberByUsername(username);
        if (password.equals(member.getPassword())) {
            Cookie cookie = new Cookie("password", password);
            //设置cookie的有效时间
            cookie.setMaxAge(60 * 24);//以秒为单位
            response.addCookie(cookie);
            //设置session的有效时间
            request.getSession().setMaxInactiveInterval(60*24);
            return new ModelAndView("/main", map);
        } else {
            map.put("failMsg", "登陆失败,请重新登录");
            return new ModelAndView("/fail", map);
        }
    }

    /**
     * 文件上传
     * 小知识:@RequestParam使用该注解,会代替request.getParameter(“name”);
     *
     * @param uploadFile
     * @param request
     * @RequestParam(value=”name1”) String name2;会把前台name=”name1”的值赋值给变量name2.
     * 其中,在括号里会写required=true/false,代表是否需要前端必须要传入参数,
     * 如果前端页面中不存在name=pasword1的属性,required=true会报错,required=false会赋值给username变量为null.
     * 不写的话默认是required=true.
     */
    @RequestMapping(value = "/uploadFile")
    public ModelAndView uploadFile(@RequestParam("fileImport") MultipartFile uploadFile, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<String, Object>();
        //获取上传的文件名
        String fileName = uploadFile.getOriginalFilename();
        //上传位置
        String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(uploadPath);

        //判断文件是否存在
        if (!file.exists()) {
            file.mkdir();
        }
        String filePath = uploadPath + "/" + fileName;
        File realPathFile = new File(filePath);
        if (realPathFile.exists()) {
            realPathFile.delete();
        }
        try {
            //转存
            uploadFile.transferTo(realPathFile);
        } catch (Exception e) {
            e.printStackTrace();
            model.put("errorMsg", "上传失败,请重新上传");
        }
        model.put("finishMsg", "上传完成");
        model.put("fileName", fileName);
        return new ModelAndView("/demo1", model);


    }
}
