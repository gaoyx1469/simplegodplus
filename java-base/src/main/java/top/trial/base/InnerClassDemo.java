package top.trial.base;

/**
 * 此demo演示内部类的性质
 * <p>
 * 可得出结论：
 * 1.静态内部类不调用时不会加载
 * 2.加载顺序：静态成员变量-》静态代码块-》构造代码块-》构造方法
 *
 * @Author gaoyx1469
 * @Date 2020/11/3
 * @Version 1.0
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        System.out.println("======");
        OuterClass outer = new OuterClass();
        System.out.println("外部类静态成员变量加载" + (OuterClass.staticOut - OutputUtil.now));
        System.out.println("======");
        OuterClass.InnerClass inner = outer.new InnerClass();
        System.out.println("======");
        System.out.println("静态内部类静态成员变量加载" + (OuterClass.StaticInnerClass.staticIn - OutputUtil.now));
        System.out.println("======");
        OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
    }
}

class OuterClass {
    static long staticOut = System.currentTimeMillis();//外部类静态成员变量加载

    static {
        OutputUtil.delayOutput("外部类静态代码块加载");
    }

    {
        OutputUtil.delayOutput("外部类构造代码块加载");
    }

    public OuterClass() {
        OutputUtil.delayOutput("外部类构造方法调用");
    }

    class InnerClass {
        {
            OutputUtil.delayOutput("内部类构造代码块加载");
        }

        public InnerClass() {
            OutputUtil.delayOutput("内部类构造方法调用");
        }
    }

    static class StaticInnerClass {

        static long staticIn = System.currentTimeMillis();//静态内部类静态成员变量加载

        static {
            OutputUtil.delayOutput("静态内部类静态代码块加载");
        }

        {
            OutputUtil.delayOutput("静态内部类构造代码块加载");
        }

        public StaticInnerClass() {
            OutputUtil.delayOutput("静态内部类构造方法调用");
        }
    }
}

class OutputUtil {
    static long now = System.currentTimeMillis();

    public static void delayOutput(String msg) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg + (System.currentTimeMillis() - now));
    }
}
