package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.UploadImageUtil;
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
        List<XcProduct> products=productService.allProduct();
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
    public AjaxJson productSave(XcProduct productForm, @RequestParam(required=false) MultipartFile file){
        AjaxJson json=new AjaxJson();
        if (!file.isEmpty()){
            try {
                UploadImageUtil.uploadImg(file,sqlPath);
            } catch (IOException e) {
                e.printStackTrace();
                json.setSuccess(false);
                json.setMsg("上传文件失败");
                return json;
            }
        }
        String fileName = productForm.getFile();// 文件原名称
        //sqlPath+"\\"+fileName;
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
    @PostMapping(value = "/productUpdare")
    @ResponseBody
    public AjaxJson productUpdare(XcProduct productForm, @RequestParam(required=false) MultipartFile file){
        AjaxJson json=new AjaxJson();
        if (!file.isEmpty()){
            try {
                UploadImageUtil.uploadImg(file,sqlPath);
            } catch (IOException e) {
                e.printStackTrace();
                json.setSuccess(false);
                json.setMsg("上传文件失败");
                return json;
            }
        }
        String fileName = productForm.getFile();// 文件原名称
        //sqlPath+"\\"+fileName;
        productService.updateProduct(productForm);
        json.setSuccess(true);
        json.setMsg("添加成功");
        return json;
    }
    @PostMapping(value = "/loadImgae")
    @ResponseBody
    public AjaxJson loadImgae( MultipartFile file){
        AjaxJson json=new AjaxJson();
        if (!file.isEmpty()){
            try {
                UploadImageUtil.uploadImg(file,sqlPath);
            } catch (IOException e) {
                e.printStackTrace();
                json.setSuccess(false);
                json.setMsg("上传文件失败");
                return json;
            }
        }else{
            json.setSuccess(false);
            json.setMsg("没有选择文件");
            return json;
        }
        String fileName = file.getOriginalFilename();// 文件原名称
        //sqlPath+"\\"+fileName;
        json.setSuccess(true);
        json.setMsg(sqlPath+fileName);
        return json;
    }
    @GetMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView=new ModelAndView("product/product_update");
        XcProduct product=productService.findById(id).orElse(new XcProduct());
        modelAndView.addObject("product",product);
        return modelAndView;
    }

}
