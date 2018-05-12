package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.UploadImageUtil;
import com.xinchuan.console.model.PageModel;
import com.xinchuan.console.model.XcDynamic;
import com.xinchuan.console.model.XcProduct;
import com.xinchuan.console.service.XcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private XcProductService productService;
    private static String sqlPath="\\images\\product\\";
    @GetMapping("/findAll")
    public ModelAndView product(XcProduct productForm){
        ModelAndView modelAndView = new ModelAndView("product/productList");
        modelAndView.addObject("seracheForm",productForm);
        PageModel<XcProduct> products=productService.allProduct(productForm);
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @PostMapping("/deleteProduct")
    public void deleteProduct(String[] ids){
        productService.deleteProduct(ids);
    }
    @GetMapping("/productAdd")
    public ModelAndView goAddPage(){
        ModelAndView modelAndView = new ModelAndView("product/product_add");
        return modelAndView;
    }
    @PostMapping(value = "/productSave")
    @ResponseBody
    public AjaxJson productSave(XcProduct productForm){
        AjaxJson json=new AjaxJson();
        String result=productService.saveProduct(productForm);
        if ("success".equals(result)){
            json.setSuccess(true);
            json.setMsg("添加成功");
        } else {
            json.setSuccess(false);
            json.setMsg(result);
        }
        return json;
    }
    @GetMapping("/saveOrUpdatePage")
    public ModelAndView findById(@RequestParam(value = "id",defaultValue = "-1",required = false) Long id){
        ModelAndView modelAndView=new ModelAndView("product/product_saveOrUpdate");
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
