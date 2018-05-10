package com.xinchuan.console.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinchuan.console.common.Menu;
import com.xinchuan.console.model.XcAdmin;
import com.xinchuan.console.service.XcAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.IOUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信传官网首页Controller
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName IndexController.java
 */
@RestController
@RequestMapping("/xinchuan")
public class IndexController {

    private static final Gson gson = new Gson();

    @Autowired
    Resource resource;

    @Autowired
    private XcAdminService xcAdminService;

    /**
     * 首页跳转
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("xc/index");
        try {
            String str = new String(IOUtils.readFully(resource.getInputStream(), -1,true));
            modelAndView.addObject("menu",gson.fromJson(str,new TypeToken<List<Menu>>(){}.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    /**
     * 登录跳转
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("xc/login");
        return modelAndView;
    }

    /**
     * 欢迎窗口
     * @return
     */
    @GetMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView("xc/welcome");
        return modelAndView;
    }
}
