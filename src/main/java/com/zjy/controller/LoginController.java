package com.zjy.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.service.LoginService;
import com.zjy.util.Constants;
import com.zjy.util.CookieTools;
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

    @RequestMapping("/logout")
    @ResponseBody
    public DataResult logout(HttpServletRequest request, HttpServletResponse response) {
    	DataResult dataResult = new DataResult();

		request.getSession().removeAttribute(Constants.SESSION_USER);
    	CookieTools.removeCookie(Constants.COOKIE_NAME, response, request);
    	dataResult.setStatus(true);
    	dataResult.setTips("退出登录成功");
    	
    	return dataResult;
    }
    
    @RequestMapping("/login")
    @ResponseBody
    public DataResult login(@RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value="type",required=false)String type,
            @RequestParam(value = "verificationCode", required = true) String verificationCode,
            @RequestParam(value = "remFlag", required = false) String remFlag,
            HttpServletRequest request,
            HttpServletResponse response,
            ModelMap model) {
    	
        /**
         * 记住我
         * 将用户名和密码保存在本地cookie中，周期为7天
         */
        // "1"表示用户勾选记住密码
        if("1".equals(remFlag)){ 
            String loginInfo = id+","+password+","+type;
            System.out.println(loginInfo);
            CookieTools.addCookie(Constants.COOKIE_NAME, loginInfo, Constants.MAX_AGE, response, request);
        }
        
    	DataResult dataResult = null;
    	
    	if (Constants.DOCTOR_TYPE.equals(type)) {
    		dataResult = loginService.DLogin(id, password, verificationCode, request);
    	} else if (Constants.ADMIN_TYPE.equals(type)) {
    		dataResult = loginService.DLogin(id, password, verificationCode, request);
    	} else if (Constants.PATIENT_TYPE.equals(type)) {
    		dataResult = loginService.PLogin(id, password, verificationCode, request);
    	}
    	
        return dataResult;
    }
}
