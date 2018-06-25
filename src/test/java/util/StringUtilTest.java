package util;

import java.lang.reflect.Field;

import org.junit.Test;

public class StringUtilTest {

    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException {
        String s = "pwd.path.prop";
        String s1 = StringUtil.convertDotName2CamelName(s);
        System.out.println(s1);
    }

    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        String s = "pwdPathProp";
        String s1 = StringUtil.convertCamelName2DotName(s);
        System.out.println(s1);
    }
}
