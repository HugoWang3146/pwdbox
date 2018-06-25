package util;

import org.junit.Test;

import config.PropConfig;

public class ConfigUtilTest {

    @Test
    public void test1() {
        PropConfig propConfig=new PropConfig();

        System.out.println(propConfig.getTargetPath());
        System.out.println(propConfig.getDescription());
        System.out.println(propConfig.getContext());

        propConfig=ConfigUtil.loadConfig(PropConfig.class);

        System.out.println(propConfig.getTargetPath());
        System.out.println(propConfig.getDescription());
        System.out.println(propConfig.getContext());

    }
}
