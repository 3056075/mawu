package com.zm.mw.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class IndexAdminController extends BaseAdminController {
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
}
