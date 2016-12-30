package com.study.controller;

import com.study.service.MemberService;
import entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
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
     * 用户登录
     *
     * @param request
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, String username, String password) {
//        //获取请求相对路径
//        String webRealPath = request.getServletPath();
//        //获取web工程的根目录,也就是web目录的地址
//        String webRealPath1 = request.getSession().getServletContext().getRealPath("a");
//        //获取部署的项目的名称
//        String path=request.getContextPath();
        Map<String, Object> map = new HashMap<String, Object>();
        Member member = memberService.getMemberByUsername(username);
        if (password.equals(member.getPassword())) {
            return new ModelAndView("/demo1", map);
        } else {
            map.put("failMsg", "登陆失败,请重新登录");
            return new ModelAndView("/index", null);
        }
    }

    /**
     * 文件上传
     *
     * @param uploadFile
     * @param request
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
        }
        model.put("finishMsg", "上传完成");
        return new ModelAndView("/demo1", model);


    }
}
