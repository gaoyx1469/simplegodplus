package top.trial.designPattern.builderPattern;

import java.math.BigDecimal;

/**
 * 食品接口类，定义了获取食品名称、获取价格、获取打包方式三个方法
 *
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public interface Meal {
    
    String getMealName();

    BigDecimal getPrice();

    Packing getPacking();

}
