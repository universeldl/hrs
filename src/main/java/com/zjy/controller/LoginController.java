package com.zjy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.service.LoginService;
import com.zjy.util.Constants;
import com.zjy.vo.DataResult;

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
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public DataResult login(@RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value="type",required=false)String type,
            @RequestParam(value = "verificationCode", required = true) String verificationCode,
            @RequestParam("remindMe") String remindMe,
            HttpServletRequest request) {
    	
    	DataResult dataResult = null;
    	
    	if (Constants.DOCTOR_TYPE.equals(type)) {
    		dataResult = loginService.DLogin(id, password, verificationCode, remindMe, request);
    	} else if (Constants.ADMIN_TYPE.equals(type)) {
    		dataResult = loginService.DLogin(id, password, verificationCode, remindMe, request);
    	} else if (Constants.PATIENT_TYPE.equals(type)) {
    		dataResult = loginService.PLogin(id, password, verificationCode, remindMe, request);
    	}
    	
        return dataResult;
    }
}
