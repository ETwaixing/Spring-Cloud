package com.waixing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *  定义web层的切面  将这个类定义为切面类
 *
 * 根据需要在切入点不同位置的切入内容
 *   使用@Before在切入点开始处切入内容
 *   使用@After在切入点结尾处切入内容
 *   使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
 *   使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 *   使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 *
 *   在@Before中优先执行@Order(5)的内容，再执行@Order(10)的内容
 *   在@After和@AfterReturning中优先执行@Order(10)的内容，再执行@Order(5)的内容
 *
 *
 * Created by yonglang on 2017/7/3.
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    /**
     *  定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
     *  表示匹配com.waixing.controller包及其子包下的所有方法
     */
    @Pointcut("execution(public * com.waixing.controller..*.*(..))")
    public void webLog(){}

    /**
     *   使用@Before在切入点开始处切入内容
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //记录时间
        startTime.set(System.currentTimeMillis());

        //接受到请求,记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录一下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     *    使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     */
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        //处理完请求返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()) + "millisecond");
    }

}
