package com.zm.mw.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.SearchWords;
import com.zm.mw.service.SearchWordsService;

@Controller
@RequestMapping("/admin")
public class SearchWordsController extends BaseAdminController {
	@Autowired
	private SearchWordsService searchWordsService;
	
	@RequestMapping("searchWordsSearch")
	public String search(BasePagination<SearchWords> page,Model model) throws ZmException {
		searchWordsService.searchSearchWords(page);
		model.addAttribute("page", page);
		return "admin/searchWordsSearch";
	}

	
}
