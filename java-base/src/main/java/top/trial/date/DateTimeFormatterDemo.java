package top.trial.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * JAVA8提供了新的时间日期API，此处演示DateTimeFormatter的使用
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(dtf.format(localDateTime1));
        System.out.println(dtf.parse("20200909"));
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dtf1.format(localDateTime1));
    }
}
