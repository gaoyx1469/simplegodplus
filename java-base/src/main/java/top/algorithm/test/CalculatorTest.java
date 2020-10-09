package top.algorithm.test;

import top.algorithm.realization.PostfixExpressionCalculator;
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
        System.out.println("-------------简单计算器演示---------------");
        String expression = "31 * 4.5 * 5.1 + 100.01";
        List<String> expressionList = CalculatorUtils.getSimpleExpressionList(expression);
        System.out.println(expressionList);//中缀集合
        double calc = SimpleCalculator.calc(expression);
        System.out.println(calc);//计算结果
        System.out.println("-------------逆波兰计算器演示---------------");
        expression = "1+((2+3)*4+1)/2-5";
        //expressionList = CalculatorUtils.getSimpleExpressionList(expression);//中缀表达式
        //System.out.println(expressionList);
        //expressionList = CalculatorUtils.getPostExpressionList(expressionList);//后缀表达式
        //System.out.println(expressionList);
        calc = PostfixExpressionCalculator.calc(expression);
        System.out.println(calc);
    }
}
