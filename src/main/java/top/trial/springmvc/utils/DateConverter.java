package top.trial.springmvc.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换器，字符串转换日期
 *
 * @Author gaoyx1469
 * @Date 2020/7/26
 * @Version 1.0
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        try {
            if (str.contains("-")) {
                return df1.parse(str);
            } else if (str.contains("/")) {
                return df2.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
