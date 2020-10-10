package top.trial.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SpringBoot的QuickStart控制器类
 *
 * @Author gaoyx1469
 * @Date 2020/10/10
 * @Version 1.0
 */
@Controller
public class QuickStartController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello Spring Boot";
    }
}
