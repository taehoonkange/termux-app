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

    /**
     * Purpose: input null object
     * Input: parameter object is null
     * Expected:
     *      "Definition", null, "def" -> "**Definition**: def  "
     *      "NullInput", null, null   -> "**NullInput**: null  "
     */
    public void testGetSingleLineMarkdownStringEntryNull() {
        String nullObjectResult = MarkdownUtils.getSingleLineMarkdownStringEntry("Definition", null, "def");
        assertEquals(nullObjectResult, "**Definition**: def  ");

        String nullObjectAndDefinitionResult = MarkdownUtils.getSingleLineMarkdownStringEntry("NullInput", null, null);
        assertEquals(nullObjectAndDefinitionResult, "**NullInput**: null  ");
    }

    /**
     * Purpose: input plain object
     * Input: "Time", currentTimeStamp
     * Expected: "**Time**: `{currentTimeStamp}`  "
     */
    public void testGetSingleLineMarkdownStringEntry() {
        String currentTimeStamp = new MilliSecondUTCTimeStamp().getCurrentTimeStamp();
        String result1 = MarkdownUtils.getSingleLineMarkdownStringEntry("Time", currentTimeStamp, "-");
        assertEquals(result1, "**Time**: `" + currentTimeStamp + "`  ");
    }

    /**
     * Purpose: input plain object
     * Input: "Time", currentTimeStamp, "-"
     * Expected: "**Time**:
     *            ```
     *            currentTimeStamp
     *            ```
     *            "
     */
    public void testGetMultiLineMarkdownStringEntry() {
        String currentTimeStamp = new MilliSecondUTCTimeStamp().getCurrentTimeStamp();
        String result = MarkdownUtils.getMultiLineMarkdownStringEntry("Time", currentTimeStamp, "-");
        assertEquals(result, "**Time**:\n```\n" + currentTimeStamp + "\n```\n");
    }

}
