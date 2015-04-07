package com.zm.mw.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.common.exception.ZmException;
import com.zm.user.service.UserService;

@Controller
@RequestMapping("/admin")
public class PasswordController extends BaseAdminController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userPassword")
	public String password(String oldpass,String newpass,String repnewpass,Model model){
		model.addAttribute("message", "修改成功");
		try {
			userService.updatePassword(oldpass, newpass, repnewpass);
		} catch (ZmException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "admin/userPassword";
	}
}
