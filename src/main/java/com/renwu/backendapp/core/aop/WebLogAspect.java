package com.renwu.backendapp.core.aop;

import com.renwu.backendapp.core.utils.LoggerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *  WEB请求操作日志的处理切面
 *  @author ChenZhang
 */
@Aspect
@Component
public class WebLogAspect {

    @Pointcut("execution(public * com.renwu..*Controller.*(..))")
    public void logPointCut() { }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object ob = pjp.proceed();// ob 方法的返回值

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuffer logInfo = new StringBuffer();
        logInfo.append("[URL:").append(request.getRequestURI().toString()).append("],");
        logInfo.append("[参数:").append(Arrays.toString(pjp.getArgs())).append("],");
        logInfo.append("[HTTP_METHOD:").append(request.getMethod()).append("],");
        logInfo.append("[IP:").append(request.getRemoteAddr()).append("],");
        logInfo.append("[耗时（毫秒）:").append(System.currentTimeMillis() - startTime).append("]");

        LoggerUtil.info(WebLogAspect.class, logInfo.toString());

        return ob;
    }
}
