package top.algorithm.test;

import top.algorithm.realization.SimpleCalculator;
import top.algorithm.util.CalculatorUtils;

import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/8/24
 * @Version 1.0
 */
public class CalculatorTest {
    public static void main(String[] args) {
        String expression = "31 * 4.5 * 5.1 + 100.01";
        List<String> expressionList = CalculatorUtils.getSimpleExpressionList(expression);
        System.out.println(expressionList.toString());
        double calc = SimpleCalculator.calc(expression);
        System.out.println(calc);
    }
}
