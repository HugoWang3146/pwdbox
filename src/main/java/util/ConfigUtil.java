package util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;

public class ConfigUtil {

    public static <T> T loadConfig(Class<T> configClass) {
        final T instance = instantiateObject(configClass);
        Field[] fields = configClass.getDeclaredFields();

        Properties properties = new Properties();
        try {
            properties.load(ConfigUtil.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.stream(fields).forEach(field -> {
            String convertedName=StringUtil.convertCamelName2DotName(field.getName());
            String value=properties.getProperty(convertedName);
            if(value!=null){
                try {
                    field.setAccessible(true);
                    field.set(instance,value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

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
