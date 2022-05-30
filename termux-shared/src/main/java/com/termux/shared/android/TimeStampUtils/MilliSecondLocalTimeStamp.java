package com.termux.shared.android.TimeStampUtils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MilliSecondLocalTimeStamp extends TimeStampUtils{
    @Override
    String getDataFromat(){
        return "yyyy-MM-dd_HH.mm.ss.SSS";
    }
    @Override
    TimeZone getTimeZone(){
        return TimeZone.getDefault();
    }
}
