package com.renwu.backendapp;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 错误页面配置
 *
 * @author xb4876
 *
 */
@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

	/**
	 * 自定义错误文件位置
	 */
	@Override
	public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {

		ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errors/401.html");
		ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/errors/403.html");
		//1、按错误的类型显示错误的网页
		//错误类型为404，找不到网页的，默认显示404.html网页
		ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errors/404.html");
		//错误类型为500，表示服务器响应错误，默认显示500.html网页
		ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errors/500.html");

		errorPageRegistry.addErrorPages(error401Page, error403Page, error404Page, error500Page);
	}
}