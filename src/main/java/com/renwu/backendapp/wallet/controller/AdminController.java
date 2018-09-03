package com.renwu.backendapp.wallet.controller;

import com.renwu.backendapp.wallet.entity.AppUse;
import com.renwu.backendapp.wallet.entity.Question;
import com.renwu.backendapp.wallet.service.AppUseService;
import com.renwu.backendapp.wallet.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
public class AdminController {

	@Autowired
	private AppUseService service;

	@Autowired
	private QuestionService questionService;
	/**
	 * 管理主界面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/")
	public String adminIndex(Model model) {
		model.addAttribute("dashboard", true);
		model.addAttribute("userCount", service.userCount());//用户数量
		model.addAttribute("dayActive", service.dayActive());//日活跃量

		model.addAttribute("newUseCount", service.newUseCount());//新增装机量（当天）
		model.addAttribute("allUseCount", service.allUseCount());//累计装机量
		model.addAttribute("allActiveCount", service.allActiveCount());//累计活跃数量
		model.addAttribute("allHelpCount", questionService.allHelpCount());//累计反馈数量
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

	/**
	 * 周日活跃量
	 *
	 * @return
	 */
	@PostMapping("/admin/appuse/weekActive")
	@ResponseBody
	public List<AppUse> weekActive() {
		List<AppUse> list = service.weekActive();
		return list;
	}

	/**
	 * 根据手机型号统计安装数量
	 * @return
	 */
	@PostMapping("/admin/appuse/devCount")
	@ResponseBody
	public List<AppUse> devCount() {
		List<AppUse> list = service.devCount();
		return list;
	}

	/**
	 * 热门文章（前十）
	 * @return
	 */
	@PostMapping("/admin/appuse/question3")
	@ResponseBody
	public List<Question> getQuestion3() {
		//热门文章（前十）
		List<Question> questionList = questionService.getQuestion3(new Question());
		return questionList;
	}
}
