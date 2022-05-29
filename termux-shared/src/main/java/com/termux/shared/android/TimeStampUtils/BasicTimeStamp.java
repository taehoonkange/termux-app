package com.termux.shared.android.TimeStampUtils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BasicTimeStamp extends TimeStampUtils{
    @Override
    SimpleDateFormat logic() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    }
}
