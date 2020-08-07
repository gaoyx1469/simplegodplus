package top.trial.spring.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Date;

/**
 * AOP日志处理类
 *
 * @Author gaoyx1469
 * @Date 2020/8/7
 * @Version 1.0
 */
@Component("logAop")
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    private Date visitTime;
    private Class clazz;
    private Method method;

    @Pointcut("execution(* top.trial.springmvc.controller..*(..))")
    private void pointCut() {
    }

    /**
     * 前置通知，主要获取visitTime、执行的URL和方法
     *
     * @param joinPoint
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        System.out.println("日志记录-doBefore");
        visitTime = new Date();
        clazz = joinPoint.getTarget().getClass();//要访问的类
        String methodName = joinPoint.getSignature().getName();//获取方法名
        Object[] args = joinPoint.getArgs();//获取方法参数

        //获取Method对象
        if (args == null || args.length == 0)
            method = clazz.getMethod(methodName);
        else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; ++i) {
                classes[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classes);
        }

    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("日志记录-endLogging");
        long executionTime = new Date().getTime() - visitTime.getTime();//访问时长

        //通过反射获取URL
        if (clazz != null && method != null && clazz != LogAop.class) {

            String classPath = "";
            String methodPath = "";

            //获取类上的@RequestMapping注解的value值
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classPaths = classAnnotation.value();
                classPath = classPaths[0];
            }

            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if (methodAnnotation != null) {
                String[] methodPaths = methodAnnotation.value();
                methodPath = methodPaths[0];
            }

            String url = classPath + methodPath;
        }

        //获取访问的IP地址
        //web.xml配置监听器RequestContextListener，就可以在此类中注入HttpServletRequest
        String ip = request.getRemoteAddr();

        //获取当前用户（）
        SecurityContext sc = SecurityContextHolder.getContext();//拿到当前登录用户上下文
        User principal = (User) sc.getAuthentication().getPrincipal();//拿到当前用户
        String username = principal.getUsername();

        //以下方式也能拿到User对象
        //request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

    }
}
