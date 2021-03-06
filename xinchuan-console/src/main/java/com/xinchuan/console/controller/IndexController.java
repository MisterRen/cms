package com.xinchuan.console.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinchuan.console.common.Menu;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.*;
import com.xinchuan.console.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.IOUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
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
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("xinchuan/index");
        XcAdmin admin = xcAdminService.findOne(1l);
        XcAdmin admin1 = xcAdminService.findByName("laxi");
        try {
            String str = new String(IOUtils.readFully(resource.getInputStream(), -1, true), "UTF-8");
            Gson gson = new Gson();
            modelAndView.addObject("menu", gson.fromJson(str, new TypeToken<List<Menu>>() {
            }.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("xinchuan/login");
        return modelAndView;
    }


    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("xinchuan/welcome");
        return modelAndView;
    }

    @GetMapping("/upload")
    @ResponseBody
    public boolean upload() {
        return true;
    }

    @PostMapping("/loginCheck")
    public ModelAndView loginCheck(XcAdmin xcAdmin, HttpSession session) {
        ModelAndView modelAndView = null;
        XcAdmin admin = xcAdminService.login(xcAdmin.getAdminNme(), xcAdmin.getAdminPwd());
        if (admin != null) {
            session.setAttribute("userInfo", admin);
            modelAndView = new ModelAndView("redirect:admin/index");
        } else {
            modelAndView = new ModelAndView("redirect:/login");
        }

        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView first() {
        ModelAndView modelAndView = new ModelAndView("index/index");
        XcProduct p = new XcProduct();
        p.setIsShow(0);
        PageModel<XcProduct> productPage = xcProductService.allProduct(p);
        modelAndView.addObject("productPage", productPage);//产品
        //新闻//
        XcNews n = new XcNews();
        n.setIsShow(0);
        PageModel<XcNews> newsPage = xcNewsService.pageQuery(n);
        modelAndView.addObject("newsPage", newsPage);//新闻
        //团队//
        XcTeamManage t = new XcTeamManage();
        t.setIsShow(0);
        PageModel<XcTeamManage> teamPage = xcTeamManageService.allXcTeamManage(t);
        modelAndView.addObject("teamPage", teamPage);//新闻
        return modelAndView;
    }

    @GetMapping("/xinchuan/company")
    public ModelAndView company() {
        ModelAndView modelAndView = new ModelAndView("index/company");
        XcDynamic d = new XcDynamic();
        d.setIsShow(0);
        PageModel<XcDynamic> dynamicPage = xcDynamicService.allDynamic(d);
        modelAndView.addObject("dynamicPage", dynamicPage);//公司
        return modelAndView;
    }

    @GetMapping("/xinchuan/news")
    public ModelAndView news(XcNews xcNews) {
        ModelAndView modelAndView = new ModelAndView("index/news");
        //新闻//
        xcNews.setIsShow(0);
        xcNews.setPageSize(5);
        PageModel<XcNews> newsPage = xcNewsService.pageQuery(xcNews);
        modelAndView.addObject("newsPage", newsPage);//新闻
        return modelAndView;
    }

    @GetMapping("/xinchuan/newsDetail")
    public ModelAndView newsDetail(Long id) {
        ModelAndView modelAndView = new ModelAndView("index/newsDetail");
        XcNews news = xcNewsService.findNewsById(id);
        List<XcNews> prevNew = xcNewsService.findNewsPrevId(id);//上一条
        List<XcNews> nextNew = xcNewsService.findNewsNextId(id);//下一条
        if(!prevNew.isEmpty()){
            modelAndView.addObject("prevNew", prevNew.get(0));//上一条新闻
        }
        if(!nextNew.isEmpty()){
            modelAndView.addObject("nextNew", nextNew.get(0));//下一条新闻
        }
        modelAndView.addObject("news", news);//新闻
        return modelAndView;
    }

    @GetMapping("/xinchuan/serverDetail")
    public ModelAndView prouct(@RequestParam(value = "requestId",defaultValue = "-1",required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("index/serverDetail");
        XcProduct p = new XcProduct();
        p.setIsShow(0);
        PageModel<XcProduct> productPage = xcProductService.allProduct(p);//查询所有显示的产品

        XcProduct xcProduct = xcProductService.findById(id).orElse(productPage.getList().get(0));
        modelAndView.addObject("productPage", productPage);//所有产品
        modelAndView.addObject("xcProduct", xcProduct);//当前产品
        return modelAndView;
    }

    @GetMapping("/xinchuan/about")
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView("index/about");
        return modelAndView;
    }

    @GetMapping("/xinchuan/recruit")
    public ModelAndView recruit() {
        ModelAndView modelAndView = new ModelAndView("index/recruit");
        XcRecruit r = new XcRecruit();
        r.setIsShow(0);
        PageModel<XcRecruit> recruitPage = xcRecruitService.findAll(r);
        modelAndView.addObject("recruitPage", recruitPage);//公司
        return modelAndView;
    }
    @GetMapping("/xinchuan/server")
    public ModelAndView server() {
        ModelAndView modelAndView = new ModelAndView("index/server/server");
        return modelAndView;
    }
    @GetMapping("/xinchuan/server1")
    public ModelAndView server1() {
        ModelAndView modelAndView = new ModelAndView("index/server/server1");
        return modelAndView;
    }
    @GetMapping("/xinchuan/server2")
    public ModelAndView server2() {
        ModelAndView modelAndView = new ModelAndView("index/server/server2");
        return modelAndView;
    }
    @GetMapping("/xinchuan/server3")
    public ModelAndView server3() {
        ModelAndView modelAndView = new ModelAndView("index/server/server3");
        return modelAndView;
    }
    @GetMapping("/xinchuan/server4")
    public ModelAndView server4() {
        ModelAndView modelAndView = new ModelAndView("index/server/server4");
        return modelAndView;
    }

}
