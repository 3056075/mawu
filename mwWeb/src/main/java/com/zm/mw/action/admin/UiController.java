package com.zm.mw.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.common.action.CommonJson;
import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.Ui;
import com.zm.mw.service.UiService;

@Controller
@RequestMapping("/admin")
public class UiController extends BaseAdminController {
	@Autowired
	private UiService uiService;
	
	@RequestMapping("uiSearch")
	public String search(BasePagination<Ui> page,Model model) throws ZmException {
		uiService.searchUi(page);
		model.addAttribute("page", page);
		return "admin/uiSearch";
	}

	@RequestMapping("uiEdit")
	public String edit(Integer uiId,Model model) throws ZmException {
		Ui ui = uiService.findByUiId(uiId);
		model.addAttribute("ui", ui);
		return "admin/uiEdit";
	}
	
	@RequestMapping("uiEditSave")
	public String editSave(Ui ui,Model model) {		
		try {
			uiService.saveOrUpdate(ui);
		} catch (Exception e) {
			model.addAttribute("message", "保存失败！");
		}
		model.addAttribute("message", "保存成功！");
		return "admin/uiEdit";
	}
	
	@RequestMapping("uiDelete")
	@ResponseBody
	public CommonJson delete(Integer uiId) {		
		CommonJson result = new CommonJson();
		try {
			uiService.delete(uiId);
		} catch (ZmException e) {
			result.setCode("false");
			result.setMessage(e.getMessage());;
		}
		return result;
	}
}
