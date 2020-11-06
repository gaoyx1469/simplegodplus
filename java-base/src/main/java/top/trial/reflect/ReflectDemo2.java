package top.trial.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 使用反射获取泛型和注解信息
 *
 * @Author gaoyx1469
 * @Date 2020/11/6
 * @Version 1.0
 */
@SuppressWarnings("all")
public class ReflectDemo2 {

    @SuppressWarnings("unused")
    public void test1(Map<String, GameEntity> map, List<String> list) {
        System.out.println("test1");
    }

    @SuppressWarnings("unused")
    public Map<String, GameEntity> test2() {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method m1 = ReflectDemo2.class.getMethod("test1", Map.class, List.class);
        Type[] genericParameterTypes = m1.getGenericParameterTypes();//获取方法的参数类型
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {//判断是否是参数化类型，即是不是泛型类型，是的话，可以获取泛型的类型
                for (Type actualTypeArgument : ((ParameterizedType) genericParameterType).getActualTypeArguments()) {
                    System.out.println("$" + actualTypeArgument);
                }
            }
        }
        Method m2 = ReflectDemo2.class.getMethod("test2");
        Type genericReturnType = m2.getGenericReturnType();//获取方法的返回值类型
        System.out.println("#" + genericReturnType);
        if (genericReturnType instanceof ParameterizedType) {
            for (Type actualTypeArgument : ((ParameterizedType) genericReturnType).getActualTypeArguments()) {
                System.out.println("$" + actualTypeArgument);
            }
        }

        //注意：Annotation 'SuppressWarnings.class' is not retained for reflective access
        SuppressWarnings annotation = m1.getAnnotation(SuppressWarnings.class);
        System.out.println(annotation);//获取不到

    }
}
