package top.trial.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

/**
 * JAVA8提供了新的时间日期API，此处演示ZonedDate/ZonedTime/ZonedDateTime的使用
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class ZonedDateTimeDemo {
    public static void main(String[] args) {
        Set<String> set = ZoneId.getAvailableZoneIds();//获取全部Zone的ID
        System.out.println(set.toString());
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);
    }
}
