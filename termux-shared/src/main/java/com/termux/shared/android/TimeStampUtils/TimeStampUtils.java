package com.termux.shared.android.TimeStampUtils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class TimeStampUtils {
    public String getCurrentTimeStamp() {
        @SuppressLint("SimpleDateFormat")
        String dataFormat = getDataFromat();
        TimeZone timeZone = getTimeZone();
        final SimpleDateFormat df = new SimpleDateFormat(dataFormat);
        df.setTimeZone(timeZone);
        return df.format(new Date());
    }

    abstract String getDataFromat() ;
    abstract TimeZone getTimeZone() ;


}
