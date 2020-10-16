package top.trial.designPattern.prototypePattern;

/**
 * 测试原型模式浅拷贝和深拷贝
 *
 * @Author gaoyx1469
 * @Date 2020/10/16
 * @Version 1.0
 */
public class PrototypePatternMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        //testShallowCopy();//测试浅拷贝
        testDeepCopy();
    }

    private static void testDeepCopy() throws CloneNotSupportedException {
        DeepCopy orig = new DeepCopy(1, "第一个");
        orig.setCopy(new DeepCopy(2, "第二个"));

        System.out.println("开始克隆");
        DeepCopy after1 = orig.clone();
        DeepCopy after2 = orig.copy();
        System.out.println("克隆完毕");

        System.out.println("是否完成克隆：" + !(orig == after1));
        System.out.println("是否完成克隆：" + !(orig == after2));
        System.out.println();

        System.out.println("比较克隆值是否有问题");
        System.out.println(orig);
        System.out.println(after1);
        System.out.println(after2);

        System.out.println();
        System.out.println("是否是深拷贝：" + !(orig.getCopy() == after1.getCopy()));
        System.out.println("是否是深拷贝：" + !(orig.getCopy() == after2.getCopy()));
        System.out.println("是否是深拷贝：" + !(orig.getCopy().hashCode() == after1.getCopy().hashCode()));
        System.out.println("是否是深拷贝：" + !(orig.getCopy().hashCode() == after2.getCopy().hashCode()));
    }

    private static void testShallowCopy() throws CloneNotSupportedException {

        ShallowCopy orig = new ShallowCopy(1, "第一个");
        orig.setCopy(new ShallowCopy(2, "第二个"));

        //克隆过程可知，没有调用构造方法，而是内存二进制流的拷贝，性能好
        System.out.println("开始克隆");
        ShallowCopy after = orig.clone();
        System.out.println("克隆完毕");

        System.out.println("是否完成克隆：" + !(orig == after));
        System.out.println();

        System.out.println("比较克隆值是否有问题");
        System.out.println(orig);
        System.out.println(after);

        System.out.println();
        System.out.println("是否是深拷贝：" + !(orig.getCopy() == after.getCopy()));
        System.out.println("是否是深拷贝：" + !(orig.getCopy().hashCode() == after.getCopy().hashCode()));
    }
}
