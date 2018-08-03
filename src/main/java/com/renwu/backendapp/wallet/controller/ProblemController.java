package com.renwu.backendapp.wallet.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.core.model.Message;
import com.renwu.backendapp.core.utils.LoggerUtil;
import com.renwu.backendapp.core.web.BaseController;
import com.renwu.backendapp.wallet.entity.Problem;
import com.renwu.backendapp.wallet.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/problem")
public class ProblemController extends BaseController {

	private Message message = new Message();

	@Autowired
	private ProblemService service;


	/**
	 * 问题反馈管理列表页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/problemList")
	public String problemList(Model model) {
		model.addAttribute("problems", true);
		return "admin/problem/problemList";
	}

	/**
	 * 获取问题反馈列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getProblemList", method = RequestMethod.GET)
	public Map<String, Object> getProblemList(Problem problem) {
		//将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(problem.getPageNum(), problem.getPageSize());
		PageInfo result = service.getProblemList(problem);
		return getBootstrapData(result);
	}

	/**
	 * 跳转问题反馈页面
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit")
	public String problemEdit(Model model, @RequestParam int id) {
		model.addAttribute("problemEdit", service.findOne(id));
		return "admin/problem/problemEdit";
	}

	/**
	 * 问题反馈提交操作
	 *
	 * @param problem
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/edit")
	public String problemEdit(Model model, @ModelAttribute Problem problem) {
		int code = 0;
		try {
			code = service.edit(problem);
			message.setMsg(code, "问题反馈修改成功");
			model.addAttribute("message", message);
		} catch (Exception e) {
			LoggerUtil.error(ProblemController.class, e.toString());
			message.setMsg(code, "问题反馈修改失败");
			model.addAttribute("message", message);
		}
		return "redirect:/problem/problemList";
	}

	/**
	 * 问题反馈删除操作
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
