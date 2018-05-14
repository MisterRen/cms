package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcProduct;
import com.xinchuan.console.service.XcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/xp")
public class ProductController {
    @Autowired
    private XcProductService productService;
    private static String sqlPath="\\images\\xp\\";
    @GetMapping("/listView")
    public ModelAndView product(XcProduct productForm){
        ModelAndView modelAndView = new ModelAndView("xp/listView");
        modelAndView.addObject("seracheForm",productForm);
        PageModel<XcProduct> products=productService.allProduct(productForm);
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @PostMapping("/enable")
    public AjaxJson enable(XcProduct productForm){
        productService.isEnableNews(productForm);
        return new AjaxJson();
    }
    @PostMapping("/delOne")
    public AjaxJson delOne(Long id){
        AjaxJson ajaxJson = new AjaxJson();
        try {
            productService.delOne(id);
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

    @PostMapping(value = "/productSave")
    @ResponseBody
    public AjaxJson productSave(XcProduct productForm){
        AjaxJson json=new AjaxJson();
        String result=productService.saveProduct(productForm);
        if ("success".equals(result)){
            json.setSuccess(true);
            json.setMsg("保存成功");
        } else {
            json.setSuccess(false);
            json.setMsg(result);
        }
        return json;
    }
    @GetMapping("/addView")
    public ModelAndView findById(@RequestParam(value = "id",defaultValue = "-1",required = false) Long id){
        ModelAndView modelAndView=new ModelAndView("xp/addView");
        XcProduct product=productService.findById(id).orElse(new XcProduct());
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping(value = "/productUpdate")
    @ResponseBody
    public AjaxJson productUpdate(XcProduct product){
        AjaxJson json=new AjaxJson();
        String result=productService.updateProduct(product);
        if ("success".equals(result)){
            json.setSuccess(true);
            json.setMsg("修改成功");
        } else {
            json.setSuccess(false);
            json.setMsg(result);
        }
        return json;
    }
}
