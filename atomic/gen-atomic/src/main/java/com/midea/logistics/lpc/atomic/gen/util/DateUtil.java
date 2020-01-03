package com.midea.logistics.lpc.atomic.gen.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    private static final String SDF_YYYY_MM_DD = "yyyy-MM-dd";
    private static final String SDF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static final String SDF_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final long DAY = 86400000L;
    private static final long HOUR = 3600000L;
    private static final long MIN = 60000L;
    private static final long SEC = 1000L;


    public static final String getYyyyMmDd(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdfYms = new SimpleDateFormat("yyyy-MM-dd");
            return sdfYms.format(date);
        }
    }

    public static final String getYyyyMmDd(Long date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdfYms = new SimpleDateFormat("yyyy-MM-dd");
            return sdfYms.format(date);
        }
    }

    public static final String getYyyyMmDdHhMmSs(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdfYmdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdfYmdhms.format(date);
        }
    }

    public static final String getYyyyMmDdHhMmSs(Long date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdfYmdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdfYmdhms.format(date);
        }
    }

    public static final String getYyyyMmDdHhMmSsSss(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdfYmdhmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            return sdfYmdhmss.format(date);
        }
    }

    public static final String getYyyyMmDdHhMmSsSss(Long date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdfYmdhmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            return sdfYmdhmss.format(date);
        }
    }

    public static final Date getDate(String dateStr) {
        if (dateStr == null) {
            return null;
        } else {
            if (dateStr.length() == "yyyy-MM-dd".length()) {
                dateStr = dateStr + " 00:00:00";
            }

            if (dateStr.length() == "yyyy-MM-dd HH:mm:ss".length()) {
                SimpleDateFormat sdfYmdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                try {
                    Date date = sdfYmdhms.parse(dateStr);
                    return date;
                } catch (ParseException var3) {
                    logger.error("ParseException", var3);
                }
            }

            throw new RuntimeException("Error DateTime string");
        }
    }


    public static Date getDayBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static String getTimeDifference(Date history) {
        return getTimeDifference(history, (Date) null);
    }

    public static String getTimeDifference(Date history, Date future) {
        long now = System.currentTimeMillis();
        long his = now;
        long fut = now;
        if (history != null) {
            his = history.getTime();
        }

        if (future != null) {
            fut = future.getTime();
        }

        long timeLess = fut - his;
        long day = timeLess / 86400000L;
        timeLess %= 86400000L;
        long hour = timeLess / 3600000L;
        timeLess %= 3600000L;
        long min = timeLess / 60000L;
        timeLess %= 60000L;
        long sec = timeLess / 1000L;
        StringBuffer sb = new StringBuffer();
        if (day > 0L) {
            sb.append(day + "天 ");
        }

        if (day > 0L || hour > 0L) {
            sb.append(hour + "时 ");
        }

        if (day > 0L || hour > 0L || min > 0L) {
            sb.append(min + "分 ");
        }

        if (day > 0L || hour > 0L || min > 0L || sec > 0L) {
            sb.append(sec + "秒");
        }

        if (sb.length() == 0) {
            sb.append("0秒");
        }

        return sb.toString();
    }
}
