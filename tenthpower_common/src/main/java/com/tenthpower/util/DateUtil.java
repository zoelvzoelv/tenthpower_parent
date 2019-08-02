package com.tenthpower.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    public static String DATE_PATTERN_YYYYMMDD = "yyyy-MM-dd";
    public static String DATE_PATTERN_YYYYMMDDHHmmSS = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_PATTERN_YYYYMMDDTHHmmSS = "yyyy-MM-dd\'T\'HH:mm:ss";

    public static Date getCurDate() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Calendar cd = Calendar.getInstance();
        return cd.getTime();
    }

    public static String toString(Date date, String format) {
        if (StringUtils.hasText(format) && date != null) {
            return null;
        } else {
            SimpleDateFormat simpleDateFormat = null;
            try {
                simpleDateFormat = new SimpleDateFormat(format);
                return simpleDateFormat.format(date);
            } catch (IllegalArgumentException arg3) {
                return null;
            }
        }
    }

    public static String[] getDatePattern() {
        ArrayList patternStrList = new ArrayList();

        patternStrList.add(DATE_PATTERN_YYYYMMDD);

        patternStrList.add(DATE_PATTERN_YYYYMMDDHHmmSS);

        patternStrList.add(DATE_PATTERN_YYYYMMDDTHHmmSS);

        String[] dateFormatList = new String[0];
        return (String[]) patternStrList.toArray(dateFormatList);
    }
}
