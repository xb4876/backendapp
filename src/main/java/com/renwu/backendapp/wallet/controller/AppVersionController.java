package com.renwu.backendapp.wallet.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.core.model.Message;
import com.renwu.backendapp.core.utils.GlobleParms;
import com.renwu.backendapp.core.utils.LoggerUtil;
import com.renwu.backendapp.core.web.BaseController;
import com.renwu.backendapp.wallet.entity.AppVersion;
import com.renwu.backendapp.wallet.service.AppVersionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/appVersion")
public class AppVersionController extends BaseController {

	private Message message = new Message();

	@Autowired
	private AppVersionService service;


	/**
	 * 帮助中心列表页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/appVersionList")
	public String appVersionList(Model model) {
		model.addAttribute("appVersion", true);
		return "admin/appVersion/appVersionList";
	}

	/**
	 * 获取问题列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getVersionList", method = RequestMethod.GET)
	public Map<String, Object> getVersionList(AppVersion appVersion) {
		//将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(appVersion.getPageNum(), appVersion.getPageSize());
		PageInfo result = service.getAppVersionList(appVersion);
		return getBootstrapData(result);
	}
	/**
	 * 问题增加表单
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/add")
	public String appVersionAdd(Model model) {
		AppVersion appVersion = new AppVersion();
		appVersion.setUrl(GlobleParms.androidAppPath);
		model.addAttribute("appVersionAdd", appVersion);
		return "admin/appVersion/appVersionAdd";
	}

	/**
	 * 问题修改表单
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit")
	public String appVersionEdit(Model model, @RequestParam int id) {
		model.addAttribute("appVersionEdit", service.findOne(id));
		return "admin/appVersion/appVersionEdit";
	}

	/**
	 * 问题新增提交操作
	 *
	 * @param appVersion
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/add")
	public String appVersionAdd(Model model, @ModelAttribute AppVersion appVersion) {
		int code = 0;
		try {
			code = service.save(appVersion);

			message.setMsg(code, "问题创建成功");
			model.addAttribute("message", message);
		} catch (Exception e) {
			LoggerUtil.error(AppVersionController.class, e.toString());
			message.setMsg(code, "问题创建失败");
			model.addAttribute("message", message);
		}
		return "redirect:/appVersion/appVersionList";
	}

	/**
	 * 问题修改提交操作
	 *
	 * @param appVersion
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/edit")
	public String appVersionEdit(Model model, @ModelAttribute AppVersion appVersion) {
		int code = 0;
		try {
			code = service.edit(appVersion);
			message.setMsg(code, "问题修改成功");
			model.addAttribute("message", message);
		} catch (Exception e) {
			LoggerUtil.error(AppVersionController.class, e.toString());
			message.setMsg(code, "问题修改失败");
			model.addAttribute("message", message);
		}

		return "redirect:/appVersion/appVersionList";
	}

	/**
	 * 问题删除操作
	 * @param model
	 * @param id
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/deleteAll")
	@ResponseBody
	public Message deleteAll(Model model, @RequestParam String ids) {
		Message m = new Message();
		String idArray[] =ids.split(",");
		for(String id : idArray){
			service.delete(id);
		}
		m.setMsg(0,"删除成功");
		return m;
	}


}
