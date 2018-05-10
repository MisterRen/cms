package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcTeamManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

}
