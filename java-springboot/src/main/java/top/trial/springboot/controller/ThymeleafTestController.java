package top.trial.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 测试Thymeleaf模板引擎的使用
 *
 * @Author gaoyx1469
 * @Date 2020/10/14
 * @Version 1.0
 */
@Controller
public class ThymeleafTestController {
    @RequestMapping("bindTest")
    public String bindText(Map<String, String> map) {
        map.put("textData", "绑定TEXT数据成功");
        return "base/thymeleafTest";
    }
}
