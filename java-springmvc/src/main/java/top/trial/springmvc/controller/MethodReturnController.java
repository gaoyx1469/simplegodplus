package top.trial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author gaoyx1469
 * @Date 2020/7/29
 * @Version 1.0
 */
@Controller
@RequestMapping("/methodReturn")
public class MethodReturnController {

    /**
     * 请求转发测试入口
     */
    @RequestMapping("/gotoFirstPage")
    public String gotoFirstPage() {
        return "methodReturn";
    }

    /**
     * 请求转发测试信息展示
     */
    @RequestMapping("/gotoSuccessPage")
    public String gotoSuccessPage() {
        return "methodReturnSuccess";
    }

    /**
     * 请求转发测试
     */
    @RequestMapping("/requestForward")
    public void requestForward(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        System.out.println("请求转发");
        //model.addAttribute("showMsg", "请求转发至此处");//这个无效了
        request.setAttribute("showMsg", "请求转发至此处");

        //以下两种转发方式皆可：跳转另一个请求或者直接跳转另一个jsp页面
        //request.getRequestDispatcher("/methodReturn/gotoSuccessPage").forward(request, response);
        request.getRequestDispatcher("/WEB-INF/jsp/springmvc/methodReturnSuccess.jsp").forward(request, response);
    }

    /**
     * 请求重定向测试
     */
    @RequestMapping("/requestRedirect")
    public void requestRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("请求重定向");
        //request.setAttribute("showMsg", "请求重定向至此处");//请求重定向request域失效

        response.sendRedirect(request.getContextPath() + "/methodReturn/gotoSuccessPage");

        //无法重定向到WEB-INF目录，因此下面的方式是失效
        //response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/springmvc/methodReturnSuccess.jsp");
    }

    @RequestMapping("/responsePrint")
    public void responsePrint(HttpServletResponse response) throws IOException {
        System.out.println("直接页面输出");

        //页面会有乱码，因此增加ContentType设置
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("直接页面输出");
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        System.out.println("ModelAndView");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("addObject", "ModelAndView使用addObject添加的属性");
        modelAndView.getModel().put("getModel", "ModelAndView使用getModel添加的属性");

        //这种方式与返回字符串一致，其实返回字符串也会被封装成这种形式
        modelAndView.setViewName("methodReturnSuccess");

        return modelAndView;
    }

    @RequestMapping("keyword")
    public String keyword() {
        System.out.println("关键字转发或重定向");
        //使用关键字将无法使用视图解析器，因此需要加上前缀和后缀
        //return "forward:/WEB-INF/jsp/springmvc/methodReturnSuccess.jsp";

        //使用关键字请求重定向，不再需要加上request.getContextPath()来获取项目启动路径，已经封装好了
        return "redirect:/methodReturn/gotoSuccessPage";
    }
}
