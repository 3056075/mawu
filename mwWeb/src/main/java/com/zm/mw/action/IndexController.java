package com.zm.mw.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.common.action.BaseController;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}
}
