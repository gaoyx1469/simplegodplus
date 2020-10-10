package top.trial.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot的QuickStart主启动器
 * <p>
 * --@SpringBootApplication注解标注主程序类，说明是一个Spring Boot程序
 *
 * @Author gaoyx1469
 * @Date 2020/10/10
 * @Version 1.0
 */
@SpringBootApplication
public class QuickStartMainApplication {
    public static void main(String[] args) {
        //将Spring应用启动起来
        SpringApplication.run(QuickStartMainApplication.class, args);
    }
}
