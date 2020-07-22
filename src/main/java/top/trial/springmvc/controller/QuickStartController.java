package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springMVC QuickStart
 *
 * @Author gaoyx1469
 * @Date 2020/7/21
 * @Version 1.0
 */
@Controller
public class QuickStartController {

    @RequestMapping(path = "/springMVCQuickStart")
    public String quickStart() {
        System.out.println("QUICK START SUCCESS -- 入门成功");
        return "quickStartSuccess";
    }

    @RequestMapping("/springMVCRequestParamsBinding")
    public String requestParamsBinding() {
        return "requestBindingPage";
    }
}
