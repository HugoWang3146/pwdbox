package util;

import java.util.Properties;

public class ConfigUtil {

    public <T> T loadConfig(Class<T> configClass) {
        final T instance = instantiateObject(configClass);
        Properties prop=new Properties();

        return instance;
    }


    public static <T> T instantiateObject(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
