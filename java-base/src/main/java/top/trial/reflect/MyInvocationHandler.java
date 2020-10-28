package top.trial.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private UserOperateDao uod;

    public MyInvocationHandler(UserOperateDao uod) {
        this.uod = uod;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("此处调用前置方法");
        Object result = method.invoke(uod, args);
        System.out.println("此处调用后置方法");
        return result;
    }

}
