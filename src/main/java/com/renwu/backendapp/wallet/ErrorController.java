package com.renwu.backendapp.wallet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  跳转错误页面的控制器
 *  @author xb4876
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 401页面
     */
    @GetMapping(value = "/401")
    public String error_401() {
        return "/errors/401";
    }

    /**
     * 403页面
     */
    @GetMapping(value = "/403")
    public String error_403() {
        return "/errors/403";
    }

    /**
     * 404页面
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "/errors/404";
    }

    /**
     * 500页面
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "/errors/500";
    }

}