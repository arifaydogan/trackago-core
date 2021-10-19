package tr.com.trackago.tautil;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReflectionUtility {


    public static Object getRawFieldValue(Object source, String fieldName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String methodName = "get" + StringUtil.capitalize(fieldName);
        Method methodSetProperty = source.getClass().getMethod(methodName);
        return methodSetProperty.invoke(source);
    }

    public static String getFieldValue(Object source, String fieldName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object rawData = getRawFieldValue(source, fieldName);
        return rawData == null ? null : rawData.toString();
    }

    public static <T> T getFieldValue(Object source, String fieldName, Class<T> tClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object rawData = getRawFieldValue(source, fieldName);
        return tClass.cast(rawData);
    }

    public static List<Field> getAllDeclaredFields(Class type) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
        if (type.getSuperclass() != null) {
            fields.addAll(getAllDeclaredFields(type.getSuperclass()));
        }
        return fields;
    }

    public static Field getDeclaredField(Class clazz, String fieldName) {
        List<Field> fields = getAllDeclaredFields(clazz);
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        return null;
    }

    public static List<Method> getAllDeclaredMethods(Class type) {
        List<Method> methods = new ArrayList<>();
        methods.addAll(Arrays.asList(type.getDeclaredMethods()));
        if (type.getSuperclass() != null) {
            methods.addAll(getAllDeclaredMethods(type.getSuperclass()));
        }
        return methods;
    }

    public static Method getDeclaredMethod(Class type, String methodName) {
        List<Method> methods = getAllDeclaredMethods(type);
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }

    public static List<Parameter> getAllParameters(Method method) {
        List<Parameter> parameters = new ArrayList<>();
        parameters.addAll(Arrays.asList(method.getParameters()));
        return parameters;
    }

    public static Parameter getParameter(Method method, String parameterName) {
        List<Parameter> parameters = getAllParameters(method);
        for (Parameter param : parameters) {
            if (param.getName().equals(parameterName))
                return param;
        }
        return null;
    }

    public static Class<?> findSuperClassParameterType(Class<?> classOfInterest, int parameterIndex) {
        Class<?> subClass = classOfInterest;
        while (subClass != subClass.getSuperclass()) {
            // instance.getClass() is no subclass of classOfInterest or instance is a direct instance of classOfInterest
            subClass = subClass.getSuperclass();
            if (subClass == null) throw new IllegalArgumentException();
        }
        ParameterizedType parameterizedType = (ParameterizedType) subClass.getGenericSuperclass();
        return (Class<?>) parameterizedType.getActualTypeArguments()[parameterIndex];
    }

    public static Class<?> findClassByName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }


}
