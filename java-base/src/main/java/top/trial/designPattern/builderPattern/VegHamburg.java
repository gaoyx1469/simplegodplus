package top.trial.designPattern.builderPattern;

import java.math.BigDecimal;

/**
 * 素食汉堡实现类
 *
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public class VegHamburg extends Hamburg {
    @Override
    public String getMealName() {
        return "蔬菜汉堡";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(9);
    }
}
