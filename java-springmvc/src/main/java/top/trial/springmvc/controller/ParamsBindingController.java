package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.trial.springmvc.entity.RequestParamsBindingEntity;
import top.trial.springmvc.entity.RequestParamsConvertEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/bindingSelfConvertType")
    public String bindingSelfConvertType(RequestParamsConvertEntity requestParamsConvertEntity) {
        System.out.println(requestParamsConvertEntity);
        return "requestBindingSuccess";
    }

    @RequestMapping("/getServletAPI")
    public String getServletAPI(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println("HttpServletRequest地址："+httpServletRequest);
        System.out.println("HttpServletResponse地址："+httpServletResponse);
        System.out.println("HttpSession地址："+httpServletRequest.getSession());
        System.out.println("ServletContext地址："+httpServletRequest.getSession().getServletContext());
        return "requestBindingSuccess";
    }

}
