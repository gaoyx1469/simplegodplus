package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.trial.springmvc.entity.RequestParamsInnerBindingEntity;

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


    /**
     * 测试Ajax上送json数据信息，属性名与JavaBean属性一致，自动封装，然后返回JavaBean对象，再自动还原为json格式
     * <p>
     * 此处需要导入jackson的jar包支持，否则报错：Content type 'application/json;charset=UTF-8' not supported
     */
    @RequestMapping("/ajaxOperation")
    @ResponseBody//这个注解放在方法上和放在返回值类型上都可以
    public RequestParamsInnerBindingEntity ajaxOperation(@RequestBody RequestParamsInnerBindingEntity requestParamsInnerBindingEntity) {
        System.out.println("获取上送报文体成功");
        System.out.println(requestParamsInnerBindingEntity);
        requestParamsInnerBindingEntity.setIntVal(888);
        requestParamsInnerBindingEntity.setStringVal("控制器响应数据封装成功");
        return requestParamsInnerBindingEntity;
    }


}
