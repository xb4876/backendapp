package com.renwu.backendapp.core.security;

import com.renwu.backendapp.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全配置文件，主要是重写默认的认证方式和访问目录权限
 * 
 * @author xb4876
 *
 */
@Configuration
//@EnableWebSecurity: 禁用Boot的默认Security配置，配合@Configuration启用自定义配置
// （需要扩展WebSecurityConfigurerAdapter）
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，
// 例如最常用的@PreAuthorize
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	/**
	 * 用户自定义验证
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder(10));
		//注入userDetailsService的实现类
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	/**
	 * 客户端使用API登录
	 * 
	 * @author xb4876
	 *
	 */
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/api/v1/i/**")// 带有“i”的目录都需要认证或提供token
					.authorizeRequests().anyRequest().hasRole("USER").and().httpBasic().and().csrf().disable()
					.sessionManagement().maximumSessions(1).expiredUrl("/api/sessionExpired"); // 每个用户只有一个有效会话，第二个设备登录就挤掉前面一个
		}
	}

	/**
	 * Web Form表单登录
	 * 
	 * @author xb4876
	 *
	 */
	@Configuration
	@Order(2)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			//自定义
			http.authorizeRequests()
					.antMatchers("/api/create", "/", "/assets/**", "/plugins/**", "/static/**", "/bootstrap/**",
							"/v2/api-docs/**", "/swagger-ui.html**", "/webjars/**", "/swagger-resources/**", "/api/**") // 免认证目录
					.permitAll()
					.antMatchers("/admin/**")
					.hasRole("ADMIN")// ADMIN角色可以访问/admin目录
					.anyRequest()
					.authenticated()
					.and()
					.rememberMe()
					.tokenValiditySeconds(604800)		//记住我功能，cookies有限期是一周
					.rememberMeParameter("remember-me")		//登陆时是否激活记住我功能的参数名字，在登陆页面有展示
					.rememberMeCookieName("workspace")	//cookies的名字，登陆后可以通过浏览器查看cookies名字
					.and()
					.formLogin()
					.loginPage("/login")// 自定义登录页为/login
					//.loginProcessingUrl("/login")	// 自定义的登录接口
					//.failureForwardUrl("/login")	//登陆失败进行转发，这里回到登陆页面，参数error可以告知登陆状态
					//.defaultSuccessUrl("/admin/")	//登陆成功的url，这里去到个人首页
					.permitAll()
					.and()
					.logout()
					.permitAll()
					.and()
					.csrf()
					.disable();

		}
	}
}
