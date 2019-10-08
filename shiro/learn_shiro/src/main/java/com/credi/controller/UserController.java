package com.credi.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: He Xingchi
 * Created by Administrator on 2019/10/8.
 */
@RestController
@RequestMapping
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("userInfo:view") // 测试权限
    public String user(@RequestParam("msg") String msg) {
       return msg;
    }
}
