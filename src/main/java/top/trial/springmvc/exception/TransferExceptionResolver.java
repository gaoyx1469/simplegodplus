package top.trial.springmvc.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author gaoyx1469
 * @Date 2020/7/31
 * @Version 1.0
 */
@Component
public class TransferExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TransferException exception;
        if (ex instanceof TransferException)
            exception = (TransferException) ex;
        else
            exception = new TransferException("遇到了奇葩异常，我不认识");

        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg", exception.getShowMessage());//返回错误信息
        mav.setViewName("errorMsgPage");//跳转统一错误页面
        return mav;
    }
}
