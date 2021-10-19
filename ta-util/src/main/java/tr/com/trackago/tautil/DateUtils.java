package tr.com.trackago.tautil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.HijrahDate;
import java.time.temporal.ChronoField;
import java.util.*;

public class DateUtils {

    public static Date now() {
        return new Date();
    }

    public static Date afterDays(Date date, int days) {
        return after(date, Calendar.DAY_OF_YEAR, days);
    }

    public static Date afterMonth(Date date, int months) {
        return after(date, Calendar.MONTH, months);
    }

    public static Date afterYear(Date date, int years) {
        return after(date, Calendar.YEAR, years);
    }

    public static int getYear(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    private static Date after(Date date, int dateType, int add) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(dateType, add);
        return c.getTime();
    }

    public static String getMonthName(Date date) {
        Map<Integer, String> months = new HashMap<Integer, String>();
        months.put(1, "Ocak");
        months.put(2, "Şubat");
        months.put(3, "Mart");
        months.put(4, "Nisan");
        months.put(5, "Mayıs");
        months.put(6, "Haziran");
        months.put(7, "Temmuz");
        months.put(8, "Ağustos");
        months.put(9, "Eylül");
        months.put(10, "Ekim");
        months.put(11, "Kasım");
        months.put(12, "Aralık");
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        int monthInt = Integer.parseInt(sdf.format(date));
        return months.get(monthInt);

    }

    public static String getWeekDay(Date date) {
        Map<Integer, String> days = new HashMap<Integer, String>();
        days.put(2, "Pazartesi");
        days.put(3, "Salı");
        days.put(4, "Çarşamba");
        days.put(5, "Perşembe");
        days.put(6, "Cuma");
        days.put(7, "Cumartesi");
        days.put(1, "Pazar");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayInt = cal.get(Calendar.DAY_OF_WEEK);
        return days.get(dayInt);
    }

    public static Long getDifferenceMonth(Date firstDate, Date lastDate) {
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.setTime(firstDate);
        date2.setTime(lastDate);
        int year1 = date1.get(Calendar.YEAR);
        int month1 = date1.get(Calendar.MONTH);
        int year2 = date2.get(Calendar.YEAR);
        int month2 = date2.get(Calendar.MONTH);
        int months = ((year2 * 12) + month2) - ((year1 * 12) + month1);
        return new Long(months);
    }

    public static Long getDifferenceDays(Date firstDate, Date lastDate) {
        if (ObjectUtil.isEmpty(firstDate) || ObjectUtil.isEmpty(lastDate) || firstDate.compareTo(lastDate) > 0) {
            return null;
        }
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.setTime(firstDate);
        date2.setTime(lastDate);
        long time1Millis = date1.getTimeInMillis();
        long time2Millis = date2.getTimeInMillis();
        double d1 = ((double) time1Millis) / (1000 * 60 * 60 * 24);
        double d2 = ((double) time2Millis) / (1000 * 60 * 60 * 24);
        double difference = Math.round(Math.abs((d1 - d2) / 30));
        return new Long((new Double(difference)).longValue());
    }

    public static Date changeDayOfDate(Date date, int day) {
        return changeDateForType(date, Calendar.DAY_OF_MONTH, day);
    }

    public static Date changeMonthOfDate(Date date, int month) {
        return changeDateForType(date, Calendar.MONTH, month);
    }

    public static Date changeYearOfDate(Date date, int year) {
        return changeDateForType(date, Calendar.YEAR, year);
    }

    private static Date changeDateForType(Date date, int dateType, int changedValue) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(dateType, changedValue);
        return cal.getTime();
    }

    public static Date toDate(Long milSec) {
        return new Date(milSec);
    }

    public static boolean beforeNow(Date date) {
        return date.before(now());
    }

    public static boolean afterNow(Date date) {
        return date.after(now());
    }

    public static String getTarihFormatli(Date tarih, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(tarih);
    }

    public static Date getTarihFormatli(String tarih, String format) throws ParseException {
        Date date = null;
        if (tarih != null) {
            date = new SimpleDateFormat(format).parse(tarih);
        }
        return date;
    }

    public static Date stringToDate(String tarih, String seperator) throws ParseException {
        return getTarihFormatli(tarih, "dd" + seperator + "MM" + seperator + "yyyy");
    }

    public static Date createDate(int day, int month, int year) throws ParseException {
        String dateAsString = day + "/" + month + "/" + year;
        return getTarihFormatli(dateAsString, "dd/MM/yyyy");
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


    public static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    public static boolean sameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public static boolean isReligiousHoliday(Date date) {

        //Hicri 12.ayın 9u başlangıç (Zilhicce 9 Kurban Bayramı Arefesi 4 gün bayram)
        HijrahDate qurban = HijrahDate.now().with(ChronoField.DAY_OF_MONTH, 9).with(ChronoField.MONTH_OF_YEAR, 12);
        //Hicri 9.ayın 30u başlangıç (Ramazan 30 Ramazan Bayramı Arefesi 3 gün bayram)
        HijrahDate ramadan = HijrahDate.now().with(ChronoField.DAY_OF_MONTH, 30).with(ChronoField.MONTH_OF_YEAR, 9);
        //  System.out.println("HijrahDate : " + qurban);

        LocalDate qurbanStart = LocalDate.from(qurban);
        LocalDate qurbanEnd = qurbanStart.plusDays(4);
        // System.out.println("Start : " + qurbanStart  +" end : "+qurbanEnd);
        LocalDate ramadanStart = LocalDate.from(ramadan).plusDays(1);
        LocalDate ramadanEnd = ramadanStart.plusDays(3);
        //  System.out.println("Start : " + ramadanStart  +" end : "+ramadanEnd);

        LocalDate myDate = DateUtils.convertToLocalDateViaInstant(date);

        if (myDate.isEqual(qurbanStart) || (myDate.isAfter(qurbanStart) && myDate.isBefore(qurbanEnd)) || myDate.isEqual(qurbanEnd)) {
            return true;
        }

        if (myDate.isEqual(ramadanStart) || (myDate.isAfter(ramadanStart) && myDate.isBefore(ramadanEnd)) || myDate.isEqual(ramadanEnd)) {
            return true;
        }

        return false;
    }

    public static boolean isNationalHoliday(Date date) throws ParseException {
        int currentYear = getYear(date);
        Date yilbasi = createDate(1, 1, currentYear);
        Date nisan23 = createDate(23, 5, currentYear);
        Date mayis1 = createDate(1, 5, currentYear);
        Date mayis19 = createDate(19, 5, currentYear);
        Date temmuz15 = createDate(15, 7, currentYear);
        Date agustos30 = createDate(30, 8, currentYear);
        Date ekim29 = createDate(29, 10, currentYear);
        Date ekim28 = createDate(28, 10, currentYear);

        if (sameDay(date, yilbasi) || sameDay(date, nisan23) || sameDay(date, mayis1) || sameDay(date, mayis19)
                || sameDay(date, temmuz15) || sameDay(date, agustos30) || sameDay(date, ekim28) || sameDay(date, ekim29)) {
            return true;
        }
        return false;
    }

    public static boolean isWeekend(Date date) {
        Set<String> weekend = new HashSet<>();
        weekend.add("Cumartesi");
        weekend.add("Pazar");
        return weekend.contains(getWeekDay(date));
    }


    /**
     * Tatil olmayan son iş gününü getirir.
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date lastWorkDay(Date date) throws ParseException {
        if (DateUtils.isNationalHoliday(date) || DateUtils.isReligiousHoliday(date) || DateUtils.isWeekend(date)) {
            return lastWorkDay(afterDays(date, -1));
        }
        return date;
    }

    public static int getAgeFromBirthDate(Date birthDate) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(DateUtils.now()));
        int age = (d2 - d1) / 10000;
        return age;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtils.lastWorkDay(createDate(8, 6, 2020)));
    }

}
