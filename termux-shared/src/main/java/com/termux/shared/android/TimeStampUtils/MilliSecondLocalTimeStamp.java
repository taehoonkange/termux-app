package com.termux.shared.android.TimeStampUtils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MilliSecondLocalTimeStamp extends TimeStampUtils{
    @Override
    SimpleDateFormat logic() {
        return new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.SSS");
    }
}
