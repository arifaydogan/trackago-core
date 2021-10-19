package tr.com.trackago.tautil;

import java.util.Base64;

public class Base64Util {

  public static final String NAN = "NaN";

  public static String encodeStr(String text) {
    if (StringUtil.isNotEmpty(text)) {
      return new String(Base64.getEncoder().encode(text.getBytes()));
    } else {
      return NAN;
    }
  }

  public static String decodeStr(String text) {
    if (StringUtil.isNotEmpty(text)) {
      return new String(Base64.getDecoder().decode(text.getBytes()));
    } else {
      return NAN;
    }
  }
}
