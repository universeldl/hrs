package com.zjy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjy.service.LoginService;
import com.zjy.util.Constants;
import com.zjy.util.CryptographyHelper;

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
            @RequestParam(value="type",required=false)String type,
            @RequestParam("verificationCode") String verificationCode,
            HttpServletRequest request) {
//        String salt = CryptographyHelper.getRandomSalt();
//        String saltpassword = CryptographyHelper.encrypt(password, salt);
        if(!verificationCode.toLowerCase().equals(request.getSession().getAttribute(Constants.VERIFY_CODE).toString().toLowerCase())) {
            return "loginerror";
        }
        if(String.valueOf(Constants.DOCTOR_TYPE).equals(type)&&service.DLogin(id,password)) {
            return "doctorindex";
        }else if(String.valueOf(Constants.ADMIN_TYPE).equals(type)&&service.DLogin(id,password)) {
            return "adminindex";
        }else if(String.valueOf(Constants.PATIENT_TYPE).equals(type)&&service.PLogin(id,password)) {
            return "patientindex";
        }
        return "loginerror";
    }
}
