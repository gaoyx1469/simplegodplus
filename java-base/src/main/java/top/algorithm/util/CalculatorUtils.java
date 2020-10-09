package top.algorithm.util;

import java.util.*;

/**
 * @Author gaoyx1469
 * @Date 2020/8/24
 * @Version 1.0
 */
public class CalculatorUtils {
    public static Map<String, Integer> map;

    static {
        map = new HashMap<>();
        map.put("+", 0);
        map.put("-", 0);
        map.put("*", 1);
        map.put("/", 1);
        map.put("(", 2);
        map.put(")", 2);
    }

    /**
     * 简单表达式分解，将字符串表达式分解为数字、操作符、括号的List集合
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


    /**
     * 计算
     *
     * @param n  double
     * @param m  double
     * @param op String
     * @return double
     */
    public static double oper(double n, double m, String op) {
        return switch (op) {
            case "+" -> n + m;
            case "-" -> n - m;
            case "*" -> n * m;
            case "/" -> n / m;
            default -> throw new RuntimeException("操作符有误");
        };
    }

    /**
     * 表达式分解，将中缀表达式分解为后缀表达式
     *
     * @param expression String
     * @return List<String>
     */
    public static List<String> getPostExpressionList(List<String> expression) {
        Stack<String> list1 = new Stack<>();//存储运算符
        List<String> list2 = new ArrayList<>();//存储结果

        for (String s : expression) {

            if (map.containsKey(s) && map.get(s) < 2) {//是操作符

                while (!list1.empty() && map.get(list1.peek()) != 2 && map.get(s) <= map.get(list1.peek())) {//如果运算符栈不是空且栈顶元素优先级大于当前元素
                    list2.add(list1.pop());
                }
                list1.push(s);

            } else if (map.containsKey(s) && map.get(s) == 2) {//是括号
                if ("(".equals(s)) {
                    list1.push(s);
                } else {
                    while (!"(".equals(list1.peek())) {
                        list2.add(list1.pop());
                    }
                    list1.pop();
                }
            } else {
                list2.add(s);
            }
        }

        while (!list1.empty())
            list2.add(list1.pop());
        return list2;
    }
}
