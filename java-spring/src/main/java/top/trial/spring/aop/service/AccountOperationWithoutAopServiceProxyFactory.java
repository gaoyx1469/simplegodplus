package top.trial.spring.aop.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import top.util.jdbc.TransactionUtil;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author gaoyx1469
 * @Date 2020/7/17
 * @Version 1.0
 */
@Component
public class AccountOperationWithoutAopServiceProxyFactory {

    //注入无事务版本的service实现类对象
    @Resource(name = "accountOperationWithoutAopServiceProxyImpl")
    AccountOperationService service;

    @Bean
    public AccountOperationService getProxy() {
        return (AccountOperationService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                Object returnVal = null;
                try {
                    TransactionUtil.startTransaction();
                    returnVal = method.invoke(service, args);
                    TransactionUtil.commit();
                } catch (Exception e) {
                    TransactionUtil.rollback();
                    e.printStackTrace();
                } finally {
                    TransactionUtil.release();
                }
                return returnVal;
            }
        });
    }

}
