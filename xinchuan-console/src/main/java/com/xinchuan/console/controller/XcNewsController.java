package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.AjaxMsg;
import com.xinchuan.console.model.XcNews;
import com.xinchuan.console.service.XcNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView listView(){

        return new ModelAndView("xn/listView");
    }

    @GetMapping("/pageQuery")
    public Page<XcNews> pageQuery(@PageableDefault(value = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){
        /*Sort sort = new Sort(Sort.Direction.DESC, "id");*/
        return xcNewsService.pageQuery(pageable);
    }

    @PostMapping("/delete")
    public AjaxJson delete(@RequestParam(value = "id",required = true) Long id){
        xcNewsService.deleteNews(id);
        return new AjaxJson();
    }

    @PostMapping("/enable")
    public AjaxJson enable(@RequestParam(value = "id",required = true) Long id,@RequestParam(value = "isShow",required = true) int isShow){
        XcNews xcNews = new XcNews();
        xcNews.setId(id);
        xcNews.setIsShow(isShow);
        xcNewsService.isEnableNews(xcNews);
        return new AjaxJson();
    }
}
