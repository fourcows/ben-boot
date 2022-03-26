package ben.common.web.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FieldUtil {
    /**
     * 获取类及其父类所有字段
     */
    public static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {//当父类为null的时候说明此时是Object类
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass(); //遍历父类
        }
        return fields;
    }

    /**
     * 获取指定类对象中有指定注解的字段
     */
    public static List<Field> getFieldsByAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        return FieldUtil.getAllFields(clazz).stream()
                .filter(field -> field.isAnnotationPresent(annotationClass))
                .collect(Collectors.toList());
    }
}
