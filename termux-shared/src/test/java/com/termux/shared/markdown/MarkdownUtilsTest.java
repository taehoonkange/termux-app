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

    /**
     * Purpose: Test text with backticks
     * Input: "test`with``up```to````5`````backticks"
     * Expected:
     *      test`with``up```to````5`````backticks -> ``````test`with``up```to````5`````backticks``````
     *      `test starts with backticks           -> `` `test starts with backticks``
     *      `test wrapped with backticks`         -> `` `test wrapped with backticks` ``
     */
    public void testGetMarkdownCodeForStringWithBackticks() {
        String upTo5backtickResult = MarkdownUtils.getMarkdownCodeForString("test`with``up```to````5`````backticks", false);
        assertEquals(upTo5backtickResult, "``````test`with``up```to````5`````backticks``````"); // should have 6 backticks

        String startsWithBackticksResult = MarkdownUtils.getMarkdownCodeForString("`test starts with backticks", false);
        assertEquals(startsWithBackticksResult, "`` `test starts with backticks``");

        String wrapWithBackticksResult = MarkdownUtils.getMarkdownCodeForString("`test wrapped with backticks`", false);
        assertEquals(wrapWithBackticksResult, "`` `test wrapped with backticks` ``");
    }

}
