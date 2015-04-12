package com.zm.mw.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.common.action.CommonJson;
import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.Suggestion;
import com.zm.mw.service.SuggestionService;

@Controller
@RequestMapping("/admin")
public class SuggestionController extends BaseAdminController {
	@Autowired
	private SuggestionService suggestionService;

	@RequestMapping("suggestionSearch")
	public String search(BasePagination<Suggestion> page, Model model)
			throws ZmException {
		suggestionService.searchSuggestion(page);
		model.addAttribute("page", page);
		return "admin/suggestionSearch";
	}

	@RequestMapping("suggestionRead")
	@ResponseBody
	public CommonJson read(Integer suggestionId, Model model)
			throws ZmException {
		CommonJson result = new CommonJson();
		try {
			suggestionService.saveReadSuggestion(suggestionId);
		} catch (ZmException e) {
			result.setCode("false");
			result.setMessage(e.getMessage());
		}
		return result;
	}
}
