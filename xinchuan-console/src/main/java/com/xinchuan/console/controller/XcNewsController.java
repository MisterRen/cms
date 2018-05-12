package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcNews;
import com.xinchuan.console.service.XcNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * <p>
 * 新闻管理controller
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月10日)
 * @version 1.0
 * @fileName XcNewsController.java
 */
@RestController
@RequestMapping("/xn")
public class XcNewsController {

    @Autowired
    private XcNewsService xcNewsService;

    @GetMapping("/listView")
    public ModelAndView listView(XcNews news){
        ModelAndView modelAndView = new ModelAndView("xn/listView");
        modelAndView.addObject("seracheForm",news);
        PageModel<XcNews> XcNewsPage=xcNewsService.pageQuery(news);
        modelAndView.addObject("newsList",XcNewsPage);
        return modelAndView;
    }
    @GetMapping("/addView")
    public ModelAndView addView(@RequestParam(value = "id",defaultValue = "-1",required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("xn/addView");
        modelAndView.addObject("news",xcNewsService.findNewsById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public AjaxJson delete(@RequestParam(value = "id",required = true) Long id){
        xcNewsService.deleteNews(id);
        return new AjaxJson();
    }

    @PostMapping("/enable")
    public AjaxJson enable(XcNews xcNews){
        xcNewsService.isEnableNews(xcNews);
        return new AjaxJson();
    }
    @PostMapping("/add")
    public AjaxJson add(XcNews xcNews){
        xcNews.setCreateTime(new Date());
        xcNewsService.saveOrUpdate(xcNews);
        return new AjaxJson();
    }
}
