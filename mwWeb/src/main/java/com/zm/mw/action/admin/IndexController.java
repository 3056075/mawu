package com.zm.mw.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.common.action.BaseController;
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	@RequestMapping("admin/index")
	public String index(){
		return "admin/index";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
}
