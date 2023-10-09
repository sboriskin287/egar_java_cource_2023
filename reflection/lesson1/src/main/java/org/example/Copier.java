package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Copier {
    public static Main.Department copy(Main.Department origin) {
        var depClass = origin.getClass();
        var declaredFields = depClass.getDeclaredFields();
        try {
            var newDep = depClass.getDeclaredConstructor().newInstance();
            for (Field f : declaredFields) {
                f.setAccessible(true);
                var maxAnn = f.getDeclaredAnnotation(Max.class);
                if (maxAnn != null) {
                    var val = maxAnn.value();
                    if (((int) f.get(origin)) > val) {
                        throw new RuntimeException("Value exceeds max value");
                    }
                }
                f.set(newDep, f.get(origin));
            }
            return newDep;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
