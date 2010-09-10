package org.ojqa.domain.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author ybak
 * 
 */
public final class Util {

    private Util() {
    }

    public static Class<?> getGenericType(final Class<?> clazz) {
        final Type genericSuperclass = clazz.getGenericSuperclass();
        return (Class<?>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

}
