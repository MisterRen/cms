package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcConsult;
import com.xinchuan.console.service.XcConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * <p>
 * 咨询
 * </p>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月11日)
 * @version 1.0
 * @fileName XcConsultController.java
 */
@RestController
@RequestMapping("/xc")
public class XcConsultController {

    @Autowired
    XcConsultService xcConsultService;

    @GetMapping("/listView")
    public ModelAndView listView(XcConsult consultForm) {
        ModelAndView modelAndView = new ModelAndView("xc/listView");
        modelAndView.addObject("seracheForm",consultForm);
        PageModel<XcConsult> consultPage=xcConsultService.pageQuery(consultForm);
        modelAndView.addObject("consultList",consultPage);
        return modelAndView;
    }

    @PostMapping("/delete")
    public AjaxJson delete(@RequestParam(value = "id", required = true) Long id) {
        xcConsultService.deleteNews(id);
        return new AjaxJson();
    }

    @PostMapping("/enable")
    public AjaxJson enable(XcConsult xcConsult) {
        xcConsultService.isEnableNews(xcConsult);
        return new AjaxJson();
    }

    @PostMapping("/add")
    public AjaxJson add(XcConsult xcConsult) {
        xcConsult.setCreateTime(new Date());
        xcConsultService.saveOrUpdate(xcConsult);
        return new AjaxJson();
    }
}
