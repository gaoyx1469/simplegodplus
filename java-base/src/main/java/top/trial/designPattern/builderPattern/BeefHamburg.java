package top.trial.designPattern.builderPattern;

import java.math.BigDecimal;

/**
 * 牛肉汉堡
 *
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public class BeefHamburg extends Hamburg {
    @Override
    public String getMealName() {
        return "牛肉汉堡";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(16);
    }
}
