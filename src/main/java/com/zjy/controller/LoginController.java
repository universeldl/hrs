package com.zjy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjy.service.LoginService;

/**
 * 用户登陆
 * 根据不同身份进入不同页面
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: LoginController.java, v 0.1 2018年3月21日 上午10:52:37 zhoujiayi Exp $
 */
@Controller
public class LoginController {
    
    @Autowired
    private LoginService service;

    @RequestMapping("/login")
    public String login(@RequestParam("id") String id,
            @RequestParam("password") String password,
            @RequestParam("type")String type) {
        if("0".equals(type)&&service.DLogin(id,password)) {
            return "doctorindex";
        }else if("1".equals(type)&&service.DLogin(id,password)) {
            return "adminindex";
        }else if("2".equals(type)&&service.PLogin(id,password)) {
            return "patientindex";
        }
        return "loginerror";
    }
}
