package top.algorithm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/8/24
 * @Version 1.0
 */
public class CalculatorUtils {

    /**
     * 简单表达式分解
     *
     * @param expression String
     * @return List<String>
     */
    public static List<String> getSimpleExpressionList(String expression) {
        List<String> list = new ArrayList<>();
        expression = expression.replace(" ", "");
        int len = expression.length();
        int start = 0;
        for (int i = 1; i < len; ++i) {
            if (!(expression.substring(i, i + 1).matches("\\d") || ".".equals(expression.substring(i, i + 1))) || !(expression.substring(i - 1, i).matches("\\d") || ".".equals(expression.substring(i - 1, i)))) {
                list.add(expression.substring(start, i));
                start = i;
            }
        }
        list.add(expression.substring(start, len));
        return list;
    }
}
