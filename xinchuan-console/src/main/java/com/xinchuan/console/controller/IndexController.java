package com.xinchuan.console.controller;

import com.baidu.ueditor.ActionEnter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinchuan.console.common.Menu;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.*;
import com.xinchuan.console.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName IndexController.java
 */
@RestController
/*@RequestMapping("/")*/
public class IndexController {

    @Autowired
    Resource resource;
    @Autowired
    XcProductService xcProductService;
    @Autowired
    XcNewsService xcNewsService;
    @Autowired
    XcTeamManageService xcTeamManageService;
    @Autowired
    private XcAdminService xcAdminService;
    @Autowired
    private XcDynamicService xcDynamicService;
    @Autowired
    private XcRecruitService xcRecruitService;

    @GetMapping("/admin/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("xinchuan/index");
        XcAdmin admin = xcAdminService.findOne(1l);
        XcAdmin admin1 = xcAdminService.findByName("laxi");
        try {
            String str = new String(IOUtils.readFully(resource.getInputStream(), -1,true));
            Gson gson = new Gson();
            modelAndView.addObject("menu",gson.fromJson(str,new TypeToken<List<Menu>>(){}.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("xinchuan/login");
        return modelAndView;
    }


    @GetMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView("xinchuan/welcome");
        return modelAndView;
    }

    @GetMapping("/upload")
    @ResponseBody
    public boolean upload(){
        return  true;
    }

    @PostMapping("/loginCheck")
    public ModelAndView loginCheck(XcAdmin xcAdmin,HttpSession session){
        ModelAndView modelAndView=null;
        XcAdmin admin=xcAdminService.login(xcAdmin.getAdminNme(),xcAdmin.getAdminPwd());
        if(admin!=null){
            session.setAttribute("userInfo",admin);
            modelAndView= new ModelAndView("redirect:/index");
        }else {
            modelAndView= new ModelAndView("redirect:/login");
        }

        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView first(){
        ModelAndView modelAndView = new ModelAndView("index/index");
        XcProduct p=new XcProduct();
        p.setIsShow(0);
        PageModel<XcProduct> productPage=xcProductService.allProduct(p);
        modelAndView.addObject("productPage",productPage);//产品
        //新闻//
        XcNews n=new XcNews();
        n.setIsShow(0);
        PageModel<XcNews> newsPage=xcNewsService.pageQuery(n);
        modelAndView.addObject("newsPage",newsPage);//新闻
        //团队//
        XcTeamManage t=new XcTeamManage();
        t.setIsShow(0);
        PageModel<XcTeamManage> teamPage=xcTeamManageService.allXcTeamManage(t);
        modelAndView.addObject("teamPage",teamPage);//新闻
        return modelAndView;
    }
    @GetMapping("/xinchuan/company")
    public ModelAndView company(){
        ModelAndView modelAndView = new ModelAndView("index/company");
        XcDynamic d=new XcDynamic();
        d.setIsShow(0);
        PageModel<XcDynamic> dynamicPage=xcDynamicService.allDynamic(d);
        modelAndView.addObject("dynamicPage",dynamicPage);//公司
        return modelAndView;
    }

    @GetMapping("/xinchuan/news")
    public ModelAndView news(){
        ModelAndView modelAndView = new ModelAndView("index/news");
        return modelAndView;
    }

    @GetMapping("/xinchuan/server")
    public ModelAndView prouct(){
        ModelAndView modelAndView = new ModelAndView("index/server");
        return modelAndView;
    }

    @GetMapping("/xinchuan/about")
    public ModelAndView about(){
        ModelAndView modelAndView = new ModelAndView("index/about");
        return modelAndView;
    }

    @GetMapping("/xinchuan/recruit")
    public ModelAndView recruit(){
        ModelAndView modelAndView = new ModelAndView("index/recruit");
        XcRecruit r=new XcRecruit();
        r.setIsShow(0);
        PageModel<XcRecruit> recruitPage=xcRecruitService.findAll(r);
        modelAndView.addObject("recruitPage",recruitPage);//公司
        return modelAndView;
    }



}
