package com.termux.shared.markdown;

import com.termux.shared.android.TimeStampUtils.MilliSecondUTCTimeStamp;

import junit.framework.TestCase;

public class MarkdownUtilsTest extends TestCase {

    /**
     * Purpose: Check when string is null or empty
     * Input: null, ""
     * Expected:
     *      null -> null
     *      ""   -> ""
     */
    public void testGetMarkdownCodeForStringEmpty() {
        assertNull(MarkdownUtils.getMarkdownCodeForString(null, true));

        String emptyStringResult = MarkdownUtils.getMarkdownCodeForString("", true);
        assertEquals(emptyStringResult, "");
    }

}
