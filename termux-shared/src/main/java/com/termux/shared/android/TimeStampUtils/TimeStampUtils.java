package com.termux.shared.android.TimeStampUtils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class TimeStampUtils {
    public String getCurrentTimeStamp() {
        @SuppressLint("SimpleDateFormat")
        final SimpleDateFormat df = logic();
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(new Date());
    }

    abstract SimpleDateFormat logic() ;


}
