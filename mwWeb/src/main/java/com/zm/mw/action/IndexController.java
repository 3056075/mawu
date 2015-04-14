package com.zm.mw.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.common.action.BaseController;
import com.zm.common.utils.StringUtils;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	@RequestMapping("index")
	public String index(HttpServletRequest request) {		
		String agent=request.getHeader("user-agent");
		if(StringUtils.isNotBlank(agent)){
			agent = agent.toLowerCase();
			if(agent.indexOf("micromessenger")>0||agent.indexOf("mobile")>0
					||agent.indexOf("mobile")>0
					||agent.indexOf("android")>0
					||agent.indexOf("blackBerry")>0
					||agent.indexOf("iphone")>0
					||agent.indexOf("ipad")>0
					||agent.indexOf("ipod")>0){
				return recommend();
			}
		}
		return "index";
	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("recommend")
	public String recommend() {
		return "recommend";
	}
	
	@RequestMapping("wxgroup")
	public String wxgroup() {
		return "wxgroup";
	}
}
