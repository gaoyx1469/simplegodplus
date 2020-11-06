package top.trial.annotation;


import top.util.properties.PropertiesUtil;

public class UnitCase {

    /**
     * 实现代码的单元测试
     *
     * @throws Exception Exception
     */
    @AnnotationUnitDemo(timeout = 1)
    @SuppressWarnings("unused")
    public void testCase() throws Exception {
        String rootDemo = PropertiesUtil.getPropertiesValueByClassloader("rootDemo.properties", "propertiesName");
        System.out.println(rootDemo);
    }

}
