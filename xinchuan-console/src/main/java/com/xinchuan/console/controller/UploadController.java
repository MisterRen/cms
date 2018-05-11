package com.xinchuan.console.controller;

import com.xinchuan.console.common.AjaxJson;
import com.xinchuan.console.common.UploadImageUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {
    private static String sqlPath="\\images\\upload\\";
    @PostMapping(value = "/loadImgae")
    @ResponseBody
    public AjaxJson loadImgae(MultipartFile file){
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

}
