package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspect(Object obj) {

        Class<?> clazz = obj.getClass();
        System.out.println("Class name: " + clazz.getName());

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Field: " + fields[i].getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Method: " + methods[i].getName());
        }
    }
}
