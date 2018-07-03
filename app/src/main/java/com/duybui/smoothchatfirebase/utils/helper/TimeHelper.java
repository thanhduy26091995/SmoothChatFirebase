package com.duybui.smoothchatfirebase.utils.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tantr on 7/25/2017.
 */

public final class TimeHelper {


    public static final String DATE_NORMAL_FORMAT = "dd/MM/yyyy";
    public static final String DATE_FORMAT_SENT_SERVER = "yyyy-MM-dd";
    public static final String DATE_OF_WEEK_FORMAT = "hh:mm:ss EEE, MMM d, yyyy";
    public static final String DATE_FORMAT_FROM_SERVER = "yyyy-MM-dd hh:mm:ss";
    public static final String DATE_FORMAT_CLIENT = "dd-MM-yyyy hh:mm:ss";
    public static final String DATE_CHAT_IN_DAY = "HH:mm";

    //    public static final String DATE_OF_WEEK_FORMAT = "EEE, MMM d";
    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String TAG = "CustomTimeTAG";

    private TimeHelper() {
    }

    /**
     * @param ISODate
     * @param dateFormat
     * @return
     */
    public static String datetimeFormat(String ISODate, String dateFormat) {
        Date date = convertISODateToDate(ISODate);
        DateFormat df = new SimpleDateFormat(dateFormat);
        String resultDateFormat = df.format(date);
        return resultDateFormat;
    }

    /**
     * convert yyyy-MM-dd hh:mm:ss => dd/MM/yyyy
     *
     * @param strDate input from server
     * @return
     */
    public static String datetimeFormatHome(String strDate) {
        String mDate = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_FROM_SERVER);
            Date date = simpleDateFormat.parse(strDate);
            DateFormat dateFormat = new SimpleDateFormat(DATE_NORMAL_FORMAT);
            mDate = dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return mDate;
    }

    public static Date convertISODateToDate(String _createDate) {
        SimpleDateFormat formatISODate = new SimpleDateFormat(ISO_DATE_FORMAT);
        Date date = null;
        try {
            date = formatISODate.parse(_createDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date convertStringToDate(String birthday) {
        SimpleDateFormat formatISODate = new SimpleDateFormat(DATE_FORMAT_SENT_SERVER);
        Date date = null;
        try {
            date = formatISODate.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String datetimeFormat(long _createDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_NORMAL_FORMAT);
        String mDateTime = simpleDateFormat.format(_createDate);
        return mDateTime;
    }

    public static String convertDateToString(Date date) {
        String strDate = "";
        DateFormat dateFormat = new SimpleDateFormat(DATE_OF_WEEK_FORMAT);
        strDate = dateFormat.format(date);
        return strDate;
    }

    public static String convertDateCurrent() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(DATE_OF_WEEK_FORMAT);
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static String convertDateTimeFormatSentServer(long _createDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_SENT_SERVER);
        String mDateTime = simpleDateFormat.format(_createDate);
        return mDateTime;
    }

    public static String convertISODateToString(long calendarGetTime) {
        SimpleDateFormat formatISODateToString = new SimpleDateFormat(ISO_DATE_FORMAT);
        String convertISODateToString = formatISODateToString.format(calendarGetTime);
        return convertISODateToString;
    }

    public static String convertIOSDateToDate(String IOSDate) {
        String stringYear = IOSDate.substring(0, 4);
        String stringMonth = IOSDate.substring(5, 7);
        String stringDate = IOSDate.substring(8, 10);
        return stringYear + "/" + stringMonth + "/" + stringDate;
    }

    public static String convertDayMothYear(String stringDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("hh:mm EE, dd/MM/yyyy").format(date);
    }

    /**
     * Nếu thời gian chat trong ngày thì hiển thị HH:mm
     *
     * @param time
     * @return
     */
    public static String getTimeAgo(long time) {
        long now = new Date().getTime();
        long diff = (now - time) / 1000; //second
        SimpleDateFormat simpleDateFormat = null;
        if (diff < 24 * 3600) {
            simpleDateFormat = new SimpleDateFormat(DATE_CHAT_IN_DAY);
            return simpleDateFormat.format(time);
        } else {
            simpleDateFormat = new SimpleDateFormat(DATE_NORMAL_FORMAT);
            return simpleDateFormat.format(time);
        }
    }

}
