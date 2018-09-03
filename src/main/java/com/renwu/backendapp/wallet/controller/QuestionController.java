package com.renwu.backendapp.wallet.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.core.model.Message;
import com.renwu.backendapp.core.utils.LoggerUtil;
import com.renwu.backendapp.core.web.BaseController;
import com.renwu.backendapp.wallet.entity.Question;
import com.renwu.backendapp.wallet.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 帮助中心controller
 * @author xb4876
 */
@Controller
@RequestMapping(value = "/question")
public class QuestionController extends BaseController {

	private Message message = new Message();

	@Autowired
	private QuestionService service;


	/**
	 * 帮助中心列表页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/questionList")
	public String questionList(Model model) {
		model.addAttribute("questions", true);
		return "admin/question/questionList";
	}

	/**
	 * 获取帮助中心问题列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getQuestionList", method = RequestMethod.GET)
	public Map<String, Object> getQuestionList(Question question) {
		//将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(question.getPageNum(), question.getPageSize());
		PageInfo result = service.getQuestionList(question);
		return getBootstrapData(result);
	}

	/**
	 * 帮助中心问题增加表单
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/add")
	public String questionAdd(Model model) {
		model.addAttribute("questionAdd", new Question());
		return "admin/question/questionAdd";
	}

	/**
	 * 帮助中心问题修改表单
	 *
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit")
	public String questionEdit(Model model, @RequestParam int id) {
		model.addAttribute("questionEdit", service.findOne(id));
		return "admin/question/questionEdit";
	}

	/**
	 * 帮助中心问题新增提交操作
	 *
	 * @param question
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/add")
	public String questionAdd(Model model, @ModelAttribute Question question) {
		int code = 0;
		try {
			code = service.save(question);
			message.setMsg(code, "问题创建成功");
			model.addAttribute("message", message);
		} catch (Exception e) {
			LoggerUtil.error(QuestionController.class, e.toString());
			message.setMsg(code, "问题创建失败");
			model.addAttribute("message", message);
		}
		return "redirect:/question/questionList";
	}

	/**
	 * 帮助中心问题修改提交操作
	 *
	 * @param question
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/edit")
	public String questionEdit(Model model, @ModelAttribute Question question) {
		int code = 0;
		try {
			code = service.edit(question);
			message.setMsg(code, "问题修改成功");
			model.addAttribute("message", message);
		} catch (Exception e) {
			LoggerUtil.error(QuestionController.class, e.toString());
			message.setMsg(code, "问题修改失败");
			model.addAttribute("message", message);
		}

		return "redirect:/question/questionList";
	}

	/**
	 * 帮助中心问题删除操作
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
