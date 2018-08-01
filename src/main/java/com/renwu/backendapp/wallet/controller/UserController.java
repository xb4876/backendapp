package com.renwu.backendapp.wallet.controller;


import com.renwu.backendapp.core.model.Message;
import com.renwu.backendapp.wallet.entity.User;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 处理用户类接口
 * 
 * @author jiekechoo
 *
 */
@RestController
@RequestMapping(value = "/api/v1/", name = "用户API")
public class UserController {



//	/**
//	 * 创建用户验证表单
//	 *
//	 * @param binder
//	 */
//	@InitBinder("userCreateForm")
//	public void initBinder(WebDataBinder binder) {
//		binder.addValidators(userCreateFormValidator);
//	}
//
//	/**
//	 * APP登录用接口
//	 *
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "i/userLogin", method = RequestMethod.POST)
//	public ResponseEntity<Message> userLogin(HttpServletRequest request) {
//		User user = userService.getCurrentUser();
//		if(user == null){
//			message.setMsg(0, "用户登录失败");
//			return new ResponseEntity<Message>(message, HttpStatus.OK);
//		}else {
//			message.setMsg(1, "用户登录成功", user);
//			return new ResponseEntity<Message>(message, HttpStatus.OK);
//		}
//
//	}
//
//	/**
//	 * 创建用户接口
//	 *
//	 * @param form
//	 * @param bindingResult
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "create", method = RequestMethod.POST)
//	public ResponseEntity<Message> handleUserCreateForm(@Valid @RequestBody UserCreateForm form,
//                                                        BindingResult bindingResult) {
//		LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
//		if (bindingResult.hasErrors()) {
//			// failed validation
//			message.setMsg(0, "user_create error: failed validation");
//			return new ResponseEntity<Message>(message, HttpStatus.OK);
//		}
//		try {
//			userService.create(form);
//		} catch (DataIntegrityViolationException e) {
//			LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate username", e);
//			bindingResult.reject("username.exists", "username already exists");
//			message.setMsg(0, "创建用户失败：用户名已存在");
//			return new ResponseEntity<Message>(message, HttpStatus.OK);
//
//		}
//		// ok, redirect
//		message.setMsg(1, "create user success");
//		return new ResponseEntity<Message>(message, HttpStatus.OK);
//	}
//
//	/**
//	 * 使用 ResponseBody作为结果 200
//	 *
//	 * @param id
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "i/user/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Message> findByUserId(@PathVariable long id) {
//		User user = userRepository.findOne(id);
//		HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
//
//		if (user == null) {
//			message.setMsg(0, "未找到用户");
//		} else {
//			message.setMsg(1, "用户信息", user);
//		}
//		return new ResponseEntity<Message>(message, status);
//	}
//
//	/**
//	 * 上传用户头像
//	 *
//	 * @param file
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "i/uploadImage", method = RequestMethod.POST)
//	public ResponseEntity<?> uploadImage(@RequestParam MultipartFile file, HttpServletRequest request) {
//		message.setMsg(1, "用户上传头像成功", userService.uploadImage(file, request));
//		return new ResponseEntity<Message>(message, HttpStatus.OK);
//
//	}
//
//	/**
//	 * 获取用户列表
//	 *
//	 * @param current
//	 * @param rowCount
//	 * @param searchPhrase
//	 * @return
//	 */
//	@RequestMapping(value = "getUserList", method = RequestMethod.POST)
//	public Object getUserList(@RequestParam(required = false) int current, @RequestParam(required = false) int rowCount,
//                              @RequestParam(required = false) String searchPhrase) {
//		return userService.getUserList(current, rowCount, searchPhrase);
//
//	}

}
