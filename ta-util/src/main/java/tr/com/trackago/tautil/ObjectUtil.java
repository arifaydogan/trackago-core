package tr.com.trackago.tautil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ObjectUtil {

    public static final ObjectUtil.Null NULL = new ObjectUtil.Null();

    public static boolean isEmpty(Object o) {
        return o == null;
    }

    public static boolean isNotEmpty(Object o) {
        return o != null;
    }

    public static Long nvl(Long firstValue, Long secondValue) {
        return isEmpty(firstValue) ? secondValue : firstValue;
    }

    public static int nvl(int firstValue, int secondValue) {
        return isEmpty(firstValue) ? secondValue : firstValue;
    }

    public static BigDecimal nvl(BigDecimal firstValue, BigDecimal secondValue) {
        return isEmpty(firstValue) ? secondValue : firstValue;
    }

    public static String nvl(String firstValue, String secondValue) {
        return StringUtil.nvl(firstValue, secondValue);
    }

    public static Object nvl(Objects firstValue, Object secondValue) {
        return isEmpty(firstValue) ? secondValue : firstValue;
    }

    public static String nvl(boolean contidion, String firstValue, String secondValue) {
        if (contidion)
            return firstValue;
        else
            return secondValue;
    }

    public static Long nvl(boolean contidion, Long firstValue, Long secondValue) {
        if (contidion)
            return firstValue;
        else
            return secondValue;
    }

    public static Object nvl(boolean contidion, Object firstValue, Object secondValue) {
        if (contidion)
            return firstValue;
        else
            return secondValue;
    }

    public static boolean equal(Object o1, Object o2) {
        if (isEmpty(o1) && isEmpty(o2))
            return true;
        if (isEmpty(o1) || isEmpty(o2))
            return false;
        return o1.equals(o2);
    }

    public static boolean notEqual(Object o1, Object o2) {
        return !equal(o1, o2);
    }

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtil.NULL;
        }
    }

}
