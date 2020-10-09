package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import top.trial.springmvc.entity.RequestParamsInnerBindingEntity;

import java.util.Map;

/**
 * 测试常用Request相关注解
 *
 * @Author gaoyx1469
 * @Date 2020/7/28
 * @Version 1.0
 */
@Controller
@RequestMapping("requestAnnotation")
@SessionAttributes("sessionA")//将request域中的某个值存入session中
public class RequestAnnotationController {

    @RequestMapping("springMVCRequestAnnotation")
    public String gotoTestPage(ModelMap map) {//同时演示从session中拿取数据
        System.out.println("拿到sessionA--" + map.get("sessionA"));
        return "requestAnnotation";
    }

    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("abc") String arg) {
        System.out.println(arg);
        return "requestAnnotationShow";
    }

    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "requestAnnotationShow";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println(id);
        return "requestAnnotationShow";
    }

    @RequestMapping("/testRequestHeader")
    //注意-RequestHeader注解也可以指定要取出的头id，如下所示，如不指定，则按照参数名匹配
    public String testRequestHeader(@RequestHeader String accept) {
        System.out.println(accept);
        return "requestAnnotationShow";
    }

    @RequestMapping("/testCookieValue")
    //注意-CookieValue注解也可以指定要取出的头id，如果不指定，则按照参数名匹配
    public String testCookieValue(@CookieValue("JSESSIONID") String value) {
        System.out.println(value);
        return "requestAnnotationShow";
    }


    @ModelAttribute
    public RequestParamsInnerBindingEntity beforeModelAttribute() {
        RequestParamsInnerBindingEntity requestParamsInnerBindingEntity = new RequestParamsInnerBindingEntity();
        requestParamsInnerBindingEntity.setIntVal(50);//注意这个值不会覆盖掉传了的值
        requestParamsInnerBindingEntity.setStringVal("ModelAttribute");
        return requestParamsInnerBindingEntity;
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(RequestParamsInnerBindingEntity requestParamsInnerBindingEntity) {
        System.out.println(requestParamsInnerBindingEntity);
        return "requestAnnotationShow";
    }

    @ModelAttribute
    public void beforeModelAttribute(Map map) {
        RequestParamsInnerBindingEntity requestParamsInnerBindingEntity = new RequestParamsInnerBindingEntity();
        requestParamsInnerBindingEntity.setIntVal(50);//注意这个值不会覆盖掉传了的值
        requestParamsInnerBindingEntity.setStringVal("ModelAttributeAnother");
        map.put("beforeModelAttribute", requestParamsInnerBindingEntity);
    }

    @RequestMapping("/testModelAttributeAnother")
    public String testModelAttributeAnother(@ModelAttribute("beforeModelAttribute") RequestParamsInnerBindingEntity requestParamsInnerBindingEntity) {
        System.out.println(requestParamsInnerBindingEntity);
        return "requestAnnotationShow";
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(String sessionA, Model model) {
        System.out.println(sessionA);
        //存储到request域对象中，然后由类上的@SessionAttributes注解将request域中指定的数据存入session
        model.addAttribute("sessionA", sessionA);
        return "requestAnnotationShow";
    }

    @RequestMapping("/testDeleteSessionAttributes")
    public String testDeleteSessionAttributes(SessionStatus status) {
        status.setComplete();
        System.out.println("删除session中所有值");
        return "requestAnnotationShow";
    }

}
