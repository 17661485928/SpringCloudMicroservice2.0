package com.qht.springbootconsumer.conf;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * AOP切面日志管理
 * author:qht
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.qht.springbootconsumer.controller.*.*(..))")
    public void webControllerLog() {
    }

    @Before("webControllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("请求地址URL=======> : " + request.getRequestURL().toString());
        logger.info("请求方式=======> : " + request.getMethod());
        logger.info("请求的IP地址=====> : " + request.getRemoteAddr());
        String requestParam = "";
        if(joinPoint.getArgs().length == 0) {
            requestParam = "{}";
        } else {
            requestParam = Arrays.toString(joinPoint.getArgs());
        }
        logger.info("请求报文打印=======>"+joinPoint.getSignature().getName()+"："+ requestParam);
    }

    @AfterReturning(returning = "responseMsg", pointcut = "webControllerLog()")
    public void doAfterReturning(Object responseMsg) throws Throwable {
        // 处理完请求，返回内容
        logger.info("返回参数=======>: " + JSONObject.toJSONString(responseMsg));
    }
}
