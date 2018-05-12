package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.model.XcRecruit;
import com.xinchuan.console.service.XcRecruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 招聘
 * </p>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月12日)
 * @version 1.0
 * @fileName XcRecruitController.java
 */
@Slf4j
@RestController
@RequestMapping("/xr")
public class XcRecruitController {

    @Autowired
    private XcRecruitService xcRecruitService;


    @GetMapping("/listView")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("xr/listView");
        List<XcRecruit> xcRecruitList = xcRecruitService.findAll();
        modelAndView.addObject("xcRecruitOldList", xcRecruitList);
        return modelAndView;
    }

    @GetMapping("/addView")
    public ModelAndView addView(@RequestParam(value = "id",defaultValue = "-1",required = false) String id){
        ModelAndView modelAndView = new ModelAndView("xr/addView");
        modelAndView.addObject("xcRecruit",  xcRecruitService.findById(id).orElse(new XcRecruit()));
        return modelAndView;
    }

    @PostMapping("/add")
    public AjaxJson add(XcRecruit xcRecruit){
        AjaxJson ajaxJson=new AjaxJson();
        try {
            xcRecruitService.saveOrUpdate(xcRecruit);
            ajaxJson.setSuccess(true);
            ajaxJson.setMsg("添加成功");
        } catch (Exception e) {
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg("添加失败");
            e.printStackTrace();
        }
        return new AjaxJson();
    }

    @PostMapping("/delAll")
    public AjaxJson delAll(String[] ids) {
        AjaxJson ajaxJson = new AjaxJson();
        try {
            xcRecruitService.delAll(ids);
            ajaxJson.setSuccess(true);
            ajaxJson.setMsg("删除成功");
        } catch (Exception e) {
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg("删除失败");
            e.printStackTrace();
            //log.error("************" + e.getMessage());
        }
        return ajaxJson;
    }


    @GetMapping("/findByDateAndName")
    public ModelAndView findByDateAndName(String startDate, String endDate, String postName) {
        ModelAndView modelAndView = new ModelAndView("xr/listView");
        List<XcRecruit> xcRecruitOldList = xcRecruitService.findByCreateTimeAndName(startDate,endDate,postName);
        modelAndView.addObject("startDate", startDate);
        modelAndView.addObject("endDate", endDate);
        modelAndView.addObject("postName", postName);
        modelAndView.addObject("xcRecruitOldList", xcRecruitOldList);
        return modelAndView;

    }
}
