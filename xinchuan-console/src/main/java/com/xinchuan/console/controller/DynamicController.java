package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.UploadImageUtil;
import com.xinchuan.console.model.XcDynamic;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcDynamicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/dynamic")
@Slf4j
public class DynamicController {
    @Autowired
    private XcDynamicService dynamicService;
    @GetMapping("/findAll")
    public ModelAndView dynamic(XcDynamic dynamicForm){
        ModelAndView modelAndView = new ModelAndView("dynamic/dynamicList");
        modelAndView.addObject("seracheForm",dynamicForm);
        List<XcDynamic> dynamics=dynamicService.allDynamic(dynamicForm);
        modelAndView.addObject("dynamics",dynamics);
        return modelAndView;
    }

    @PostMapping("/deleteDynamic")
    public void deleteDynamic(String[] ids){
        dynamicService.deleteDynamic( ids);
    }
    @GetMapping("/dynamicAdd")
    public ModelAndView goAddPage(){
        ModelAndView modelAndView = new ModelAndView("dynamic/dynamic-add");
        return modelAndView;
    }
    @PostMapping(value = "/dynamicSave")
    @ResponseBody
    public AjaxJson dynamicSave(XcDynamic dynamicForm){
        AjaxJson json=new AjaxJson();

        String fileName = dynamicForm.getFile();// 文件原名称
        //sqlPath+"\\"+fileName;
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
        String fileName = dynamicForm.getFile();// 文件原名称
        //sqlPath+"\\"+fileName;
         dynamicService.updateDynamic(dynamicForm);
        json.setSuccess(true);
        json.setMsg("添加成功");
        return json;
    }
    @GetMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView=new ModelAndView("dynamic/dynamic-update");
        XcDynamic dynamic=dynamicService.findById(id).orElse(new XcDynamic());
        modelAndView.addObject("dynamic",dynamic);
        return modelAndView;
    }

}
