package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author gaoyx1469
 * @Date 2020/7/29
 * @Version 1.0
 */
@Controller
@RequestMapping("/responseJSON")
public class ResponseJsonController {

    /**
     * 跳转主页
     */
    @RequestMapping("/responseAjax")
    public String responseAjax() {
        return "responseAjax";
    }


}
