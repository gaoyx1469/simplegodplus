package top.util.security;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author gaoyx1469
 * @Date 2020/8/7
 * @Version 1.0
 */
public class StreamFlowUtil {

    private static String sysId = "31001";//5位系统编码
    private static String orgId = "1001";//4位机构编码

    public static String get32StreamFlow() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());//14位时间戳
        String randomNumber = new Random().nextInt(900000000) + 100000000 + "";
        return sysId + orgId + date + randomNumber;
    }
}
