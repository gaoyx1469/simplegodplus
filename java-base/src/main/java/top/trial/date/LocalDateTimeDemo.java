package top.trial.date;

import java.time.LocalDateTime;

/**
 * JAVA8提供了新的时间日期API，此处演示LocalDate/LocalTime/LocalDateTime的使用
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime ldt0 = LocalDateTime.now();//获取当前时间
        System.out.println(ldt0);
        System.out.println("====================");

        LocalDateTime ldt1 = LocalDateTime.of(2020, 8, 11, 8, 40, 40);//指定时间
        System.out.println(ldt1);
        System.out.println("====================");

        LocalDateTime ldt2 = ldt1.plusDays(2);//日期时间运算，注意本来的ldt1没有改变
        System.out.println(ldt2);
        System.out.println("====================");

        LocalDateTime ldt4 = ldt1.minusMonths(1);//日期时间运算，注意本来的ldt1没有改变
        System.out.println(ldt4);
        System.out.println("====================");

    }
}
