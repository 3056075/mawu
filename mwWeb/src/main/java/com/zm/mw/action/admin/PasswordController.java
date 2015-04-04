package com.zm.mw.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class PasswordController extends BaseAdminController {
	@RequestMapping("/userPassword")
	public String password(String oldpass,String newpass,String repnewpass,Model model){
		model.addAttribute("message", "修改成功");
		
		return "admin/userPassword";
	}
}
