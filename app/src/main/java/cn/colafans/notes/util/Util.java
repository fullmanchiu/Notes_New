package cn.colafans.notes.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getDateToString(long milSecond, String pattern) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
