package com.renwu.backendapp.core.web;

import com.github.pagehelper.PageInfo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器支持类
 * @author xb4876
 * @version 2018-7-30
 */
public abstract class BaseController {

	/**
	 * 添加Flash消息
	 * @param message
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}

	
	/**
	 * 客户端返回字符串
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string) {
		try {
			response.reset();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 获取bootstrap data分页数据
	 * @param page
	 * @return map对象
	 */
	public <T> Map<String, Object> getBootstrapData(PageInfo page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", page.getList());
		map.put("total", page.getTotal());
		return map;
	}

}
