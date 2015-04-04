package com.zm.mw.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UiController extends BaseAdminController {
	@RequestMapping("uiSearch")
	public String search() {
		return "admin/uiSearch";
	}

	@RequestMapping("uiAdd")
	public String add() {
		return "admin/uiAdd";
	}
}
