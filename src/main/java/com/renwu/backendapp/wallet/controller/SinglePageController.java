package com.renwu.backendapp.wallet.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.core.model.Message;
import com.renwu.backendapp.core.utils.LoggerUtil;
import com.renwu.backendapp.core.web.BaseController;
import com.renwu.backendapp.wallet.entity.SinglePage;
import com.renwu.backendapp.wallet.service.SinglePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/singlePage")
public class SinglePageController extends BaseController {

	private Message message = new Message();

	@Autowired
	private SinglePageService service;


	/**
	 * 单页管理列表页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/singlePageList")
	public String singlePageList(Model model) {
		model.addAttribute("singlePages", true);
		return "admin/singlePage/singlePageList";
	}

	/**
	 * 获取单页列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSinglePageList", method = RequestMethod.GET)
	public Map<String, Object> getSinglePageList(Integer  pageNum, Integer  pageSize) {
		//将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		PageInfo result = service.getSinglePageList(pageNum, pageSize);
		return getBootstrapData(result);
	}
	/**
	 * 单页增加表单
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/add")
	public String singlePageAdd(Model model) {
		model.addAttribute("singlePageAdd", new SinglePage());
		return "admin/singlePage/singlePageAdd";
	}

	/**
	 * 单页修改表单
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit")
	public String singlePageEdit(Model model, @RequestParam int id) {
		model.addAttribute("singlePageEdit", service.findOne(id));
		return "admin/singlePage/singlePageEdit";
	}

	/**
	 * 单页预览页面
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/view")
	public String singlePageView(Model model, @RequestParam int id) {
		model.addAttribute("singlePageView", service.findOne(id));
		return "admin/singlePage/singlePageView";
	}

	/**
	 * 单页新增提交操作
	 *
	 * @param singlePage
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/add")
	public String singlePageAdd(Model model, @ModelAttribute SinglePage singlePage) {
		int code = 0;
		try {
			code = service.save(singlePage);
			message.setMsg(code, "单页面创建成功");
			model.addAttribute("message", message);
		} catch (Exception e) {
			LoggerUtil.error(SinglePageController.class, e.toString());
			message.setMsg(code, "单页面创建失败");
			model.addAttribute("message", message);
		}
		return "redirect:/singlePage/singlePageList";
	}

	/**
	 * 单页面修改提交操作
	 *
	 * @param singlePage
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/edit")
	public String singlePageEdit(Model model, @ModelAttribute SinglePage singlePage) {
		int code = 0;
		try {
			code = service.edit(singlePage);
			message.setMsg(code, "单页修改成功");
			model.addAttribute("message", message);
		} catch (Exception e) {
			LoggerUtil.error(SinglePageController.class, e.toString());
			message.setMsg(code, "单页修改失败");
			model.addAttribute("message", message);
		}
		return "redirect:/singlePage/singlePageList";
	}

	/**
	 * 单页面删除操作
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
