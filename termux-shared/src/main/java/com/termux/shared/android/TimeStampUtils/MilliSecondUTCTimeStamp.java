package com.termux.shared.android.TimeStampUtils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MilliSecondUTCTimeStamp extends TimeStampUtils{
    @Override
    String getDataFormat(){
        return "yyyy-MM-dd HH:mm:ss.SSS z";
    }
    @Override
    TimeZone getTimeZone(){
        return TimeZone.getTimeZone("UTC");
    }
}
