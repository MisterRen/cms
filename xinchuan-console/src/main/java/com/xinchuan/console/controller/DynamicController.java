package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcDynamic;
import com.xinchuan.console.service.XcDynamicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/xd")
@Slf4j
public class DynamicController {
    @Autowired
    private XcDynamicService dynamicService;
    @GetMapping("/listView")
    public ModelAndView dynamic(XcDynamic dynamicForm){
        ModelAndView modelAndView = new ModelAndView("xd/listView");
        modelAndView.addObject("seracheForm",dynamicForm);
        PageModel<XcDynamic> dynamics=dynamicService.allDynamic(dynamicForm);
        modelAndView.addObject("dynamics",dynamics);
        return modelAndView;
    }

    @PostMapping("/deleteDynamic")
    public void deleteDynamic(String[] ids){
        dynamicService.deleteDynamic( ids);
    }
    @GetMapping("/dynamicAdd")
    public ModelAndView goAddPage(){
        ModelAndView modelAndView = new ModelAndView("xd/dynamic-add");
        return modelAndView;
    }
    @PostMapping(value = "/dynamicSave")
    @ResponseBody
    public AjaxJson dynamicSave(XcDynamic dynamicForm){
        AjaxJson json=new AjaxJson();
        String result=dynamicService.saveDynamic(dynamicForm);
        if ("success".equals(result)){
        json.setSuccess(true);
        json.setMsg("添加成功");
        } else {
            json.setSuccess(false);
            json.setMsg(result);
        }
        return json;
    }
    @PostMapping(value = "/dynamicUpdare")
    @ResponseBody
    public AjaxJson dynamicUpdare(XcDynamic dynamicForm){
        AjaxJson json=new AjaxJson();
        String result=dynamicService.updateDynamic(dynamicForm);
        if ("success".equals(result)){
            json.setSuccess(true);
            json.setMsg("修改成功");
        } else {
            json.setSuccess(false);
            json.setMsg(result);
        }
        return json;
    }
    @GetMapping("/addView")
    public ModelAndView findById(@RequestParam(value = "id",defaultValue = "-1",required = false) Long id){
        ModelAndView modelAndView=new ModelAndView("xd/addView");
        XcDynamic dynamic=dynamicService.findById(id).orElse(new XcDynamic());
        modelAndView.addObject("dynamic",dynamic);
        return modelAndView;
    }

}
