package com.renwu.backendapp.wallet.controller;

import com.renwu.backendapp.wallet.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

	@Autowired
	private QuestionService service;

	/**
	 * 管理主界面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/")
	public String adminIndex(Model model) {
		model.addAttribute("dashboard", true);

		return "admin/index";
	}

	/**
	 * 用户管理
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/user")
	public String adminUser(Model model) {
		model.addAttribute("user", true);
		return "admin/user";
	}

	/**
	 * 富文本demo页面
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/uedit")
	public String adminUedit(Model model) {
		model.addAttribute("uedit", true);
		return "admin/uedit";
	}

}
