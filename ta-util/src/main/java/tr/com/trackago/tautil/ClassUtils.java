package tr.com.trackago.tautil;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ClassUtils {

    public static boolean hasAnnotation(Method method, Class<? extends Annotation> annotation){
        return ObjectUtil.isNotEmpty(method) ?
            ObjectUtil.isNotEmpty(annotation) ?
                ObjectUtil.isNotEmpty(method.getAnnotation(annotation))
                : false
            : false;
    }

    public static boolean hasAnnotation(Class<?> clazz, Class<? extends Annotation> annotation){
        return ObjectUtil.isNotEmpty(clazz) ?
            ObjectUtil.isNotEmpty(annotation) ?
                ObjectUtil.isNotEmpty(clazz.getAnnotation(annotation))
                : false
            : false;
    }

    public static boolean hasAnnotation(Field field, Class<? extends Annotation> annotation){
        return ObjectUtil.isNotEmpty(field) ?
            ObjectUtil.isNotEmpty(annotation) ?
                ObjectUtil.isNotEmpty(field.getAnnotation(annotation))
                : false
            : false;
    }

    public static boolean hasNotAnnotation(Field field, Class<? extends Annotation> annotation){
        return !hasAnnotation(field,annotation);
    }

    public static Class<?> getTypeArgument(Class<?> clazz, int index){
        return getGenericTypeAsClassAtIndex(clazz.getGenericSuperclass(),index);
    }

    public static Class<?> getMethodParameterTypeArgument(Method method, int paramIndex, int typeIndex){
        Parameter[] parameters = method.getParameters();
        if(parameters.length > paramIndex){
            Parameter parameter = parameters[paramIndex];
            return getGenericTypeAsClassAtIndex(parameter.getParameterizedType(),typeIndex);
        }
        return null;
    }

    public static Class<?> getGenericTypeAsClassAtIndex(Type type, int index){
        if(type instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if(actualTypeArguments.length > index)
            {
                Type resultType = actualTypeArguments[index];
                if(resultType instanceof Class){
                    return (Class<?>) resultType;
                }
                if(resultType instanceof ParameterizedType){
                    return (Class<?>)((ParameterizedType)resultType).getRawType();
                }
            }
        }
        return null;
    }

}
