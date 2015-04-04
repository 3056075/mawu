package com.zm.mw.action.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.common.exception.ZmException;
import com.zm.mw.entity.UiCategory;
import com.zm.mw.service.UiCategoryService;

@Controller
@RequestMapping("/admin")
public class UiCategoryController extends BaseAdminController {
	@Autowired
	private UiCategoryService uiCategoryService;
	
	@RequestMapping("uiCategorySearch")
	public String search(Model model) throws ZmException {
		List<UiCategory> uiCategorys = uiCategoryService.findAll();
		model.addAttribute("uiCategorys", uiCategorys);
		return "admin/uiCategorySearch";
	}

	@RequestMapping("uiCategoryEdit")
	public String edit(Integer uiCategoryId,Model model) throws ZmException {
		UiCategory uiCategory  = uiCategoryService.findByUiCategoryId(uiCategoryId);
		model.addAttribute("uiCategory", uiCategory);
		return "admin/uiCategoryEdit";
	}
	
	@RequestMapping("/uiCategoryEditSave")
	public String editSave(UiCategory uiCategory,Model model){
		try {
			uiCategoryService.saveOrUpdate(uiCategory);
		} catch (Exception e) {
			model.addAttribute("message", "保存失败！");
		}
		model.addAttribute("message", "保存成功！");
		return "admin/uiCategoryEdit";
	}
}
