package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.trial.springmvc.exception.TransferException;

/**
 * @Author gaoyx1469
 * @Date 2020/7/31
 * @Version 1.0
 */
@Controller
public class ExceptionExampleController {

    @RequestMapping("/exceptionHandler")
    public String exceptionExample() throws TransferException {
        try {
            //模拟调用DAO
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TransferException("出现了个啥子小异常，没关系");
        }
        return "quickStartSuccess";
    }

}
