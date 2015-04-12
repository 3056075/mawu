package com.zm.mw.action.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.common.pagination.BasePagination;
import com.zm.mw.service.FavoriteService;
import com.zm.user.entity.Oauth;
import com.zm.user.service.OauthService;

@Controller
@RequestMapping("/admin")
public class UserController extends BaseAdminController {
	@Autowired
	private FavoriteService favoriteService;
	@Autowired
	private OauthService oauthService;
	
	@RequestMapping("userSearch")
	public String search(BasePagination<Oauth> page,Model model) {
		Long countFav = favoriteService.findCount();
		model.addAttribute("countFav", countFav);		
		oauthService.searchOauth(page);
		model.addAttribute("page", page);
		
		List<Integer> userIds = new ArrayList<Integer>();
		if(page.getResult()!=null){
			for(Oauth oauth:page.getResult()){
				userIds.add(oauth.getUser().getUserId());
			}
		}
		Map<Integer,Integer> userFav=favoriteService.getFavoriteCount(userIds);
		model.addAttribute("userFav", userFav);
		
		return "admin/userSearch";
	}

}
