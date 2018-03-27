/**
 * 
 */
package com.zjy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjy.util.Constants;
import com.zjy.util.VerifyCodeGenerator;

/**
 * @author Mervyn
 *
 */

@RequestMapping("/verify")
@Controller
public class VerifyCodeController {

	@RequestMapping(value = "/generateVerify", method = RequestMethod.GET)
	public void generateVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		VerifyCodeGenerator.execute(request, response);
		System.out.println(request.getSession().getAttribute(Constants.VERIFY_CODE));
	}
	
}
