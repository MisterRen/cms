package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcTeamManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * @author shiJiaLiang
 * @date 2018/5/9  15:57
 */
@RestController
@RequestMapping("/teamManager")
@Slf4j
public class XcTeamManagerController {

    @Autowired
    XcTeamManageService xcTeamManageService;

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("team/team_index");
        List<XcTeamManage> xcTeamManageList=xcTeamManageService.findAll();
        modelAndView.addObject("teamList",xcTeamManageList);
        return modelAndView;
    }

    @GetMapping("/goAddPage")
    public ModelAndView goAddPage(){
        ModelAndView modelAndView = new ModelAndView("team/team_add");
        return modelAndView;
    }

    @PostMapping("/saveTeamManager")
    public AjaxJson saveTeamManager(XcTeamManage xcTeamManage){
        AjaxJson json=new AjaxJson();
        boolean saveFlag=true;
        try {
            xcTeamManage.setUserIcon("111");
            xcTeamManageService.saveAndFlush(xcTeamManage);
            json.setSuccess(true);
            json.setMsg("添加成功");
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg("添加失败");
            e.printStackTrace();
            log.error("*******teamManager:saveTeamManager*******出错啦"+e);
        }
        return json;
    }

    @PostMapping("/delAll")
    public AjaxJson delAll(String[] ids){
        AjaxJson ajaxJson=new AjaxJson();
        try {
            xcTeamManageService.delAll(ids);
            ajaxJson.setSuccess(true);
            ajaxJson.setMsg("删除成功");
        } catch (Exception e) {
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg("删除失败");
            e.printStackTrace();
            log.error("*****teamManager:delAll*******"+e.getMessage());
        }
        return ajaxJson;
    }

    @GetMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView=new ModelAndView("team/team_edit");
        XcTeamManage xcTeamManage=xcTeamManageService.findById(id).orElse(new XcTeamManage());
        modelAndView.addObject("xcTeamManage",xcTeamManage);
        return modelAndView;
    }

}
