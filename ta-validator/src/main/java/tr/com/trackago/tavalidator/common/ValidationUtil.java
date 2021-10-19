package tr.com.trackago.tavalidator.common;

import java.util.Collection;
import java.util.regex.Matcher;

public class ValidationUtil {

    public static boolean greater(Comparable<Object> value, Object than) {
        if (value != null && !(value.compareTo(than) > 0)) {
            return false;
        }
        return true;
    }


    public static boolean greaterOrEqual(Comparable<Object> value, Object than) {
        if (value != null && !(value.compareTo(than) >= 0)) {
            return false;
        }
        return true;
    }

    public static boolean length(Object value, int from, int to) {
        if (value != null) {
            String stringValue = value.toString();
            if (!(stringValue.length() >= from && stringValue.length() <= to)) {
                return false;
            }
        }
        return true;
    }

    public static boolean length(Collection<?> value, int from, int to) {
        if (value != null && !(value.size() >= from && value.size() <= to)) {
            return false;
        }
        return true;
    }

    public static boolean less(Comparable<Object> value, Object than) {
        if (value != null && !(value.compareTo(than) < 0)) {
            return false;
        }
        return true;
    }

    public static boolean lessOrEqual(Comparable<Object> value, Object than) {
        if (value != null && !(value.compareTo(than) <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean range(Comparable<Object> value, Object from, Object to) {
        return greaterOrEqual(value, from) && lessOrEqual(value, to);
    }

    public static boolean isValidTckn(Long tckn) {
        try {
            String tmp = tckn.toString();
            if (tmp.length() == 11) {
                int totalOdd = 0;
                int totalEven = 0;
                for (int i = 0; i < 9; i++) {
                    int val = Integer.valueOf(tmp.substring(i, i + 1));
                    if (i % 2 == 0) {
                        totalOdd += val;
                    } else {
                        totalEven += val;
                    }
                }
                int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));
                int lastDigit = total % 10;
                if (tmp.substring(10).equals(String.valueOf(lastDigit))) {
                    int check = (totalOdd * 7 - totalEven);
                    while (check < 0) {
                        check += 10;
                    }
                    int checkUp = check % 10;
                    if (tmp.substring(9, 10).equals(String.valueOf(checkUp))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isValidTckn(String tckn) {
        if (null != tckn && tckn.matches("^([1-9]{1}[0-9]{10})$")) {
            return isValidTckn(Long.valueOf(tckn));
        }
        return false;
    }

    public static boolean isPatternValid(String value, String regex) {
        if (value != null) {
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            if (matcher.matches()) {
                return true;
            }
        }
        return true;
    }

}
