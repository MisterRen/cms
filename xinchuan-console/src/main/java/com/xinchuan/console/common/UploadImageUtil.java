package com.xinchuan.console.common;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图片上传工具类
 * Created by charlin on 2017/9/10.
 */
public  class UploadImageUtil {

    public static String uploadImg(MultipartFile file,String sqlPath)
            throws IOException {
        if (null != file) {
            String fileName = file.getOriginalFilename();// 文件原名称
            File directory = new File("");// 参数为空
            String projectPath = directory.getCanonicalPath();
            String pat=projectPath+"/src/main/resources";//获取文件保存路径
            File fileDir=new File(pat+sqlPath);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            String path=pat+sqlPath+fileName;
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
                return sqlPath+fileName;
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("文件为空");
        }
        return null;
    }

}