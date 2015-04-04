package com.zm.mw.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class SuggestionController extends BaseAdminController {
	@RequestMapping("suggestionSearch")
	public String search() {
		return "admin/suggestionSearch";
	}
}
