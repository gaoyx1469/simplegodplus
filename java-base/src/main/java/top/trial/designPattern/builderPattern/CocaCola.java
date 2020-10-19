package top.trial.designPattern.builderPattern;

import java.math.BigDecimal;

/**
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public class CocaCola extends ColdDrink {
    @Override
    public String getMealName() {
        return "可口可乐";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(4);
    }
}
