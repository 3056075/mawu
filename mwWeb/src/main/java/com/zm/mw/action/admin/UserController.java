package com.zm.mw.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserController extends BaseAdminController {
	@RequestMapping("userSearch")
	public String search() {
		return "admin/userSearch";
	}

}
