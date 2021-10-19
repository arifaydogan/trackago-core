package tr.com.trackago.tavalidator.common;

public class RegexConstants {

  public static final String ALFANUMERIC_WITH_SPACE = "^[a-zA-Z0-9ğüşöçİĞÜŞÖÇ ]+$";
  public static final String ALFANUMERIC_WITHOUT_SPACE = "^[a-zA-Z0-9ğüşöçİĞÜŞÖÇ]+$";
  public static final String EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
  public static final String PHONE = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
  public static final String PHONE_NON_CHAR_L12 ="^\\d{12}$";
  public static final String PHONE_MOBILE="(05)[0-9][0-9][1-9]([0-9]){6}";

}
