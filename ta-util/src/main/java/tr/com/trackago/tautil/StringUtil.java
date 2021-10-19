package tr.com.trackago.tautil;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringUtil {

    public static final String SPACE = " ";
    public static final String EMPTY = "";

    public static boolean isEmpty(String s) {
        return s == null ? true : "".equals(s);
    }

    public static boolean isNotEmpty(String s) {
        return s != null ? !"".equals(s) : false;
    }

    public static String capitalize(CharSequence cs) {
        if (cs == null) {
            return null;
        }
        int strLen;
        if ((strLen = cs.length()) == 0) {
            return cs.toString();
        }
        return new StringBuilder(strLen)
                .append(Character.toTitleCase(cs.charAt(0)))
                .append(subSequence(cs, 1))
                .toString();
    }

    public static CharSequence subSequence(CharSequence cs, int start) {
        return cs == null ? null : cs.subSequence(start, cs.length());
    }

    public static String nvl(String deger, String sonuc) {
        if (deger == null)
            return sonuc;
        else
            return deger;
    }


    public static String capitalize(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            int firstCodepoint = str.codePointAt(0);
            int newCodePoint = Character.toTitleCase(firstCodepoint);
            if (firstCodepoint == newCodePoint) {
                return str;
            } else {
                int[] newCodePoints = new int[strLen];
                int outOffset = 0;
                outOffset = outOffset + 1;
                newCodePoints[outOffset] = newCodePoint;

                int codepoint;
                for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen; inOffset += Character.charCount(codepoint)) {
                    codepoint = str.codePointAt(inOffset);
                    newCodePoints[outOffset++] = codepoint;
                }

                return new String(newCodePoints, 0, outOffset);
            }
        } else {
            return str;
        }
    }

    public static String uncapitalize(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            int firstCodepoint = str.codePointAt(0);
            int newCodePoint = Character.toLowerCase(firstCodepoint);
            if (firstCodepoint == newCodePoint) {
                return str;
            } else {
                int[] newCodePoints = new int[strLen];
                int outOffset = 0;
                outOffset = outOffset + 1;
                newCodePoints[outOffset] = newCodePoint;

                int codepoint;
                for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen; inOffset += Character.charCount(codepoint)) {
                    codepoint = str.codePointAt(inOffset);
                    newCodePoints[outOffset++] = codepoint;
                }

                return new String(newCodePoints, 0, outOffset);
            }
        } else {
            return str;
        }
    }

    public static String join(Iterable<?> iterable, String separator) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), separator);
    }

    private static String join(Iterator<?> iterator, String separator) {

        // handle null, zero and one elements before building a buffer
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return "";
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return first == null ? "" : first.toString();
        }

        // two or more elements
        StringBuilder buf = new StringBuilder(256); // Java default is 16, probably too small
        if (first != null) {
            buf.append(first);
        }

        while (iterator.hasNext()) {
            if (separator != null) {
                buf.append(separator);
            }
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
        }
        return buf.toString();
    }


    public static <T> List<T> split(String param, String seperator, Class<?> type) {

        List<T> ret = new ArrayList<>();
        String[] tokens = param.split(seperator);
        if (tokens != null && tokens.length > 0) {
            for (String t : tokens) {
                if (type == Long.class) {
                    ret.add((T) new Long(t));
                } else if (type == BigDecimal.class) {
                    ret.add((T) new BigDecimal(t));
                } else if (type == Integer.class) {
                    ret.add((T) new Integer(t));
                } else if (type == null) {
                    ret.add((T) t);
                }
            }
        }
        return ret;
    }

    public static String removeNewLineChar(String text) {
        return isNotEmpty(text) ? text.replaceAll("\\r\\n|\\r|\\n", " ") : text;
    }

}
