package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.model.XcRecruit;
import com.xinchuan.console.model.XcRecruitDutyClaim;
import com.xinchuan.console.model.XcRecruitRequireClaim;
import com.xinchuan.console.service.XcRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
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
@RestController
@RequestMapping("/xr")
public class XcRecruitController {

    @Autowired
    private XcRecruitService xcRecruitService;


    @GetMapping("/listView")
    public ModelAndView listView(){

        return new ModelAndView("recruit/listView");
    }

    @GetMapping("/addView")
    public ModelAndView addView(){

        return new ModelAndView("recruit/addView");
    }

    @GetMapping("/pageQuery")
    public Page<XcRecruit> pageQuery(@PageableDefault(value = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){
        return xcRecruitService.pageQuery(pageable);
    }

    @PostMapping("/add")
    public AjaxJson add(XcRecruit xcConsult, @RequestParam(name = "dutyClaim[]",required=false) List<String> dutyClaim,
                        @RequestParam(name = "requireClaim[]",required=false)List<String> requireClaim){
        dutyClaim.forEach(x ->{
            XcRecruitDutyClaim duty = new XcRecruitDutyClaim();
            duty.setDutyClaim(x);
            xcConsult.getDuty().add(duty);
        });
        requireClaim.forEach(x ->{
            XcRecruitRequireClaim require = new XcRecruitRequireClaim();
            require.setRequireClaim(x);
            xcConsult.getRequirements().add(require);
        });

        xcConsult.setCreateTime(new Date());
        xcRecruitService.saveOrUpdate(xcConsult);
        return new AjaxJson();
    }
}
