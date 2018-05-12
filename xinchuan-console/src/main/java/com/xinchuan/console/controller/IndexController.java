package com.xinchuan.console.controller;

import com.baidu.ueditor.ActionEnter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinchuan.console.common.Menu;
import com.xinchuan.console.model.XcAdmin;
import com.xinchuan.console.service.XcAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName IndexController.java
 */
@RestController
@RequestMapping("/xinchuan")
public class IndexController {

    @Autowired
    Resource resource;

    @Autowired
    private XcAdminService xcAdminService;

    @GetMapping("/index.htm")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("xc/index");
        XcAdmin admin = xcAdminService.findOne(1l);
        XcAdmin admin1 = xcAdminService.findByName("laxi");
        try {
            String str = new String(IOUtils.readFully(resource.getInputStream(), -1,true));
            Gson gson = new Gson();
            modelAndView.addObject("menu",gson.fromJson(str,new TypeToken<List<Menu>>(){}.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("xc/login");
        return modelAndView;
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView("xc/welcome");
        return modelAndView;
    }

    @GetMapping("/upload")
    @ResponseBody
    public boolean upload(){
        return  true;
    }

    @PostMapping("/loginCheck")
    public ModelAndView loginCheck(XcAdmin xcAdmin,HttpSession session){
        ModelAndView modelAndView=null;
        XcAdmin admin=xcAdminService.login(xcAdmin.getAdminNme(),xcAdmin.getAdminPwd());
        if(admin!=null){
            session.setAttribute("userInfo",admin);
            modelAndView= new ModelAndView("redirect:/xinchuan/index");
        }else {
            modelAndView= new ModelAndView("redirect:/xinchuan/login");
        }

        return modelAndView;
    }




}
