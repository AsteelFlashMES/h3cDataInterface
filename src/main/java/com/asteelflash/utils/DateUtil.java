package com.asteelflash.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hunter.fei on 2018/6/15.
 */
public class DateUtil {


  public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  //获取当前时间之前或之后几小时 hour
  public static String getTimeByHour(int hour) {

    Calendar calendar = Calendar.getInstance();

    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

    return format.format(calendar.getTime());

  }

  //获取当前时间之前或之后几分钟 minute
  public static String getBeforeTimeByMinute(Date date, int minute) {

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    calendar.add(Calendar.MINUTE, 0 - minute);

    return format.format(calendar.getTime());

  }

  public static String formatDate(Date date) {
    return format.format(date);
  }

  public static Date parseDate(String time) {
    try {
      return format.parse(time);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String format12HDate(Date date) {
    return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
  }

  public static String formatShortDate(Date date) {
    return new SimpleDateFormat("yyyy-MM-dd").format(date);
  }
}
