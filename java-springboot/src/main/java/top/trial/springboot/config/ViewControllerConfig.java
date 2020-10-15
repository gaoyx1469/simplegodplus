package top.trial.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 视图跳转控制配置类
 *
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
@Configuration
public class ViewControllerConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置主页跳转
        //以下为使用静态资源的方式，默认static目录下的welcome.html
        registry.addViewController("/").setViewName("forward:/welcome.html");
        //以下为使用动态模板的方式
        //registry.addViewController("/").setViewName("base/thymeleafTest");
        //registry.addViewController("/").setViewName("forward:/bindTest");
    }
}
