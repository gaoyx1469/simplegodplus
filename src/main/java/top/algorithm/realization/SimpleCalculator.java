package top.algorithm.realization;

import top.algorithm.util.CalculatorUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 实现简单计算器，可输入整数和四则运算，不支持小数和括号
 *
 * @Author gaoyx1469
 * @Date 2020/8/24
 * @Version 1.0
 */
public class SimpleCalculator {

    static Map<String, Integer> map;

    static {
        map = new HashMap<>();
        map.put("+", 0);
        map.put("-", 0);
        map.put("*", 1);
        map.put("/", 1);
    }


    /**
     * 输入表达式，返回计算结果，double进行计算有精度损失
     *
     * @param expression String
     * @return int
     */
    public static double calc(String expression) {

        //解析表达式
        List<String> list = CalculatorUtils.getSimpleExpressionList(expression);

        //中缀表达式不含括号直接计算
        Stack<Double> stack1 = new Stack<>();//数栈
        Stack<String> stack2 = new Stack<>();//操作符栈


        for (String s : list) {
            if (map.containsKey(s)) {//是操作符
                if (!stack2.empty() && map.get(stack2.peek()) >= map.get(s)) {//当前操作符优先级低于或等于操作符栈的顶部操作符
                    //取数栈最上面两个数，取操作符栈最上面一个操作符，计算后将返回结果放回数栈，将当前操作符放回操作符栈
                    double m = stack1.pop();
                    double n = stack1.pop();
                    String op = stack2.pop();
                    stack1.push(oper(n, m, op));
                }
                stack2.push(s);
            } else {//是数字
                stack1.push(Double.parseDouble(s));
            }
        }

        while (!stack2.empty()) {
            double m = stack1.pop();
            double n = stack1.pop();
            String op = stack2.pop();
            stack1.push(oper(n, m, op));
        }

        return stack1.pop();
    }

    private static double oper(double n, double m, String op) {
        return switch (op) {
            case "+" -> n + m;
            case "-" -> n - m;
            case "*" -> n * m;
            case "/" -> n / m;
            default -> throw new RuntimeException("操作符有误");
        };
    }
}
