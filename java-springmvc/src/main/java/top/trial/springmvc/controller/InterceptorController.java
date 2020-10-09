package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author gaoyx1469
 * @Date 2020/7/31
 * @Version 1.0
 */
@Controller
public class InterceptorController {
    @RequestMapping("/interceptor")
    public String testInterceptor() {
        System.out.println("Controller方法执行");
        return "quickStartSuccess";
    }
}
