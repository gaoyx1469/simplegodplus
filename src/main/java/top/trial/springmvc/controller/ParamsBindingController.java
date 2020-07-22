package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.trial.springmvc.entity.RequestParamsBindingEntity;

/**
 * @Author gaoyx1469
 * @Date 2020/7/22
 * @Version 1.0
 */
@Controller
@RequestMapping("/paramsBinding")
public class ParamsBindingController {

    @RequestMapping("/bindingMostTypes")
    public String bindingMostTypes(RequestParamsBindingEntity requestParamsBindingEntity) {
        System.out.println(requestParamsBindingEntity);
        return "requestBindingSuccess";
    }

}
