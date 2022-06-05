package com.termux.shared.net.uri;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import android.net.Uri;

@RunWith(AndroidJUnit4.class)
public class UriUtilsTest {
    /**
     * Purpose: Check the null, empty or null path url string
     * Input: null, "", "file://"
     * Expected: null
     */
    @Test
    public void testGetUriFilePathWithFragmentNull() {
        assertNull(UriUtils.getUriFilePathWithFragment(null));

        Uri nullUri = Uri.parse("");
        assertNull(UriUtils.getUriFilePathWithFragment(nullUri));

        Uri nullPathUri = Uri.parse("file://");
        assertNull(UriUtils.getUriFilePathWithFragment(nullPathUri));
    }

}
