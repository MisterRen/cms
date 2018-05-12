package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.model.XcRecruitOld;
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
@RequestMapping("/recruit")
public class XcRecruitController {

    @Autowired
    private XcRecruitService xcRecruitService;


    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("recruit/listView");
        List<XcRecruitOld> xcRecruitOldList = xcRecruitService.findAll();
        modelAndView.addObject("xcRecruitOldList", xcRecruitOldList);
        return modelAndView;
    }

    @GetMapping("/saveOrUpdate")
    public ModelAndView addView(@RequestParam(value = "id",defaultValue = "-1",required = false) String id){
        ModelAndView modelAndView = new ModelAndView("recruit/addView");
        modelAndView.addObject("xcTeamManage",  xcRecruitService.findById(id).orElse(new XcRecruitOld()));
        return modelAndView;
    }

    @PostMapping("/add")
    public AjaxJson add(XcRecruitOld xcRecruitOld){
        AjaxJson ajaxJson=new AjaxJson();
        try {
            ajaxJson.setSuccess(true);
            ajaxJson.setMsg("添加成功");
            xcRecruitService.saveOrUpdate(xcRecruitOld);

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
            log.error("************" + e.getMessage());
        }
        return ajaxJson;
    }


    @GetMapping("/findByDateAndName")
    public ModelAndView findByDateAndName(String startDate, String endDate, String postName) {
        ModelAndView modelAndView = new ModelAndView("recruit/listView");
        List<XcRecruitOld> xcRecruitOldList = xcRecruitService.findByCreateTimeAndName(startDate,endDate,postName);
        modelAndView.addObject("startDate", startDate);
        modelAndView.addObject("endDate", endDate);
        modelAndView.addObject("postName", postName);
        modelAndView.addObject("xcRecruitOldList", xcRecruitOldList);
        return modelAndView;

    }
}
