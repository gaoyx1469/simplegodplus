package top.trial.reflect;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 演示基于子类的动态代理
 * <p>
 * 依赖cglib包和asm包，通过导入依赖引入
 * <p>
 * 核心接口和类：Enhancer、MethodInterceptor
 *
 * @author gaoyx
 */
public class ProxyDemo2 {

    @Test
    public void proxyTest() {
        MethodTemp mt = new MethodTemp();

        MethodTemp mtFactory = (MethodTemp) Enhancer.create(mt.getClass(), (MethodInterceptor) (proxy, method, args, methodProxy) -> {
            System.out.println("调用前");
            float money = (float) args[0];
            money = money - 1000f;
            method.invoke(mt, money);
            System.out.println("调用后");
            return null;
        });

        mtFactory.sale(5000f);
        mtFactory.earn(8000f);
    }
}
