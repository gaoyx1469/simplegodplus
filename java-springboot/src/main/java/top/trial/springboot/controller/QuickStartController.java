package top.trial.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.trial.springboot.entity.BindingTestJavaBean;

/**
 * SpringBoot的QuickStart控制器类
 *
 * @Author gaoyx1469
 * @Date 2020/10/10
 * @Version 1.0
 */
@Controller
public class QuickStartController {

    @Autowired
    BindingTestJavaBean bindingTest;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println(bindingTest);
        return "Hello Spring Boot";
    }
}
