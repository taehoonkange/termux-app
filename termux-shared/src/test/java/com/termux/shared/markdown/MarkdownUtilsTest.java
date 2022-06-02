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

    /**
     * Purpose: Test plain text and codeBlock
     * Input: "test string"
     * Expected:
     *      test string -> `test string`
     *      test string -> ```
     *                     test string
     *                     ```
     */
    public void testGetMarkdownCodeForString() {
        String plainTextResult = MarkdownUtils.getMarkdownCodeForString("test string", false);
        assertEquals(plainTextResult, "`test string`");

        String plainTextWithCodeBlockResult = MarkdownUtils.getMarkdownCodeForString("test string", true);
        assertEquals(plainTextWithCodeBlockResult, "```\ntest string\n```");
    }

}
