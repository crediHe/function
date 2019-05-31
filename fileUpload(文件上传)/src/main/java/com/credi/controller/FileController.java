package com.credi.controller;

import com.credi.po.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by xlf on 2018/9/14.
 */
@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("upload")
    @ResponseBody
    public void upload(HttpServletRequest request){

        // 拿到Request
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;

        //获取文件流
        MultipartFile file = mr.getFile("file");

        // 获取服务器存储文件夹
        String path=request.getSession().getServletContext().getRealPath("upload");
        ResultInfo resultInfo = new ResultInfo();

        if(null!=file && !file.isEmpty()){
            // 获取上传文件名
            String filename = file.getOriginalFilename();

            //存储文件
            try {
                file.transferTo(new File(path,filename));
                System.out.println("上传成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
