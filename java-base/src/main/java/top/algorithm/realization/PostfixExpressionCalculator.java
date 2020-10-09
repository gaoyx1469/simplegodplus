package top.algorithm.realization;

import top.algorithm.util.CalculatorUtils;

import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式计算器
 *
 * @Author gaoyx1469
 * @Date 2020/8/24
 * @Version 1.0
 */
public class PostfixExpressionCalculator {

    /**
     * 逆波兰计算器
     *
     * @param expression expression
     * @return double
     */
    public static double calc(String expression) {

        //解析表达式，转后缀表达式
        List<String> list = CalculatorUtils.getPostExpressionList(CalculatorUtils.getSimpleExpressionList(expression));

        //根据后缀表达式计算
        return calc(list);
    }

    /**
     * 根据后缀表达式list计算结果
     *
     * @param list List<String>
     * @return double
     */
    private static double calc(List<String> list) {

        Stack<Double> stack = new Stack<>();

        for (String s : list) {
            if (CalculatorUtils.map.containsKey(s)) {//是操作符
                double m = stack.pop();
                double n = stack.pop();
                stack.push(CalculatorUtils.oper(n, m, s));
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
        return stack.pop();
    }
}
