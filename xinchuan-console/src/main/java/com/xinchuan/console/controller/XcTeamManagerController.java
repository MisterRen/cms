package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcTeamManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author shiJiaLiang
 * @date 2018/5/9  15:57
 */
@RestController
@RequestMapping("/xt")
@Slf4j
public class XcTeamManagerController {

    @Autowired
    XcTeamManageService xcTeamManageService;

    @GetMapping("/listView")
    public ModelAndView findAll(XcTeamManage xcTeamManage) {
        ModelAndView modelAndView = new ModelAndView("xt/listView");
        PageModel<XcTeamManage> xcTeamManagePageModel=xcTeamManageService.allXcTeamManage(xcTeamManage);
        modelAndView.addObject("teamList", xcTeamManagePageModel);
        modelAndView.addObject("seracheForm", xcTeamManage);
        return modelAndView;
    }

    @GetMapping("/addView")
    public ModelAndView addView(@RequestParam(value = "id",defaultValue = "-1",required = false) String id){
        ModelAndView modelAndView = new ModelAndView("xt/addView");
        modelAndView.addObject("xcTeamManage",  xcTeamManageService.findById(id).orElse(new XcTeamManage()));
        return modelAndView;
    }

    @PostMapping("/add")
    public AjaxJson add(XcTeamManage xcTeamManage){
        AjaxJson ajaxJson=new AjaxJson();
        try {
            xcTeamManageService.saveOrUpdate(xcTeamManage);
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
            xcTeamManageService.delAll(ids);
            ajaxJson.setSuccess(true);
            ajaxJson.setMsg("删除成功");
        } catch (Exception e) {
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg("删除失败");
            e.printStackTrace();
            //log.error("*****teamManager:delAll*******" + e.getMessage());
        }
        return ajaxJson;
    }


    @GetMapping("/findByDateAndName")
    public ModelAndView findByDateAndName(String startDate, String endDate, String name) {
        ModelAndView modelAndView = new ModelAndView("xt/team_index");
        List<XcTeamManage> xcTeamManageList = xcTeamManageService.findByCreateTimeAndName(startDate,endDate,name);
        modelAndView.addObject("startDate", startDate);
        modelAndView.addObject("endDate", endDate);
        modelAndView.addObject("name", name);
        modelAndView.addObject("teamList", xcTeamManageList);
        return modelAndView;

    }
}
