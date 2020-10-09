package top.trial.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * JAVA8提供了新的时间日期API，此处演示TemporalAdjuster和TemporalAdjusters的使用
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class TemporalAdjusterDemo {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt1 = ldt.withDayOfMonth(10);
        System.out.println(ldt1);
        LocalDateTime ldt2 = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));//下个周六
        System.out.println(ldt2);
    }
}
