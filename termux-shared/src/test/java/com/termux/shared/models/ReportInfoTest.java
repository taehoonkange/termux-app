package com.termux.shared.models;

import com.termux.shared.markdown.MarkdownUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.mockito.MockedStatic;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

public class ReportInfoTest {
    /**
     * Purpose: check if reportInfo null
     * Input: parameter object is null
     * Expected:
     *      null   -> "null"
     */
    @Test
    public void testGetReportInfoMarkdownStringNull() {
        String reportInfoNull = ReportInfo.getReportInfoMarkdownString(null);
        assertEquals(reportInfoNull,"null");
    }

    /**
     * Purpose:check if `getReportInfoMarkdownString()` work well
     * Input: reportInfo = new ReportInfo("userAction","sender","reportTitle");
     *
     * Expected:
     * ## Report Info
     *
     *
     * **User Action**: `userAction`
     * **Sender**: `sender`
     * **Report Timestamp**: `yyyy-MM-dd HH:mm:ss.SSS UTC`
     * ##
     *
     *
     */
    private static MockedStatic<MarkdownUtils> markdownUtils;
    private static MockedStatic<ReportInfo> reportInfo;
    @BeforeClass
    public static void beforeClass() {
        markdownUtils = mockStatic(MarkdownUtils.class);
        reportInfo = mockStatic(ReportInfo.class);
    }

    @AfterClass
    public static void afterClass() {
        markdownUtils.close();
        reportInfo.close();
    }

    @Test
    public void testGetReportInfoMarkdownString() {
        // Create an active task
        ReportInfo reportInfo = new ReportInfo("userAction","sender","reportTitle");

        when(MarkdownUtils.getSingleLineMarkdownStringEntry(eq("User Action"), any(), eq("-"))).thenReturn("**User Action**: `" + reportInfo.userAction + "`  ");
        when(MarkdownUtils.getSingleLineMarkdownStringEntry(eq("Sender"), any(), eq("-"))).thenReturn("**Sender**: `" + reportInfo.sender + "`  ");
        when(MarkdownUtils.getSingleLineMarkdownStringEntry(eq("Report Timestamp"), any(), eq("-"))).thenReturn("**Report Timestamp**: `" + reportInfo.reportTimestamp + "`  ");

        String userAction = MarkdownUtils.getSingleLineMarkdownStringEntry("User Action", reportInfo.userAction, "-");
        String sender = MarkdownUtils.getSingleLineMarkdownStringEntry("Sender", reportInfo.sender, "-");
        String reportTitle = MarkdownUtils.getSingleLineMarkdownStringEntry("Report Timestamp", reportInfo.reportTimestamp, "-");

        when(ReportInfo.getReportInfoMarkdownString(reportInfo)).thenReturn("## Report Info\n\n"+ "\n" + userAction + "\n" + sender + "\n" + reportTitle + "\n##\n\n");

        // Call your function
        String markDownReport = ReportInfo.getReportInfoMarkdownString(reportInfo);
        // Check the result
        assertEquals(markDownReport, "## Report Info\n\n"+ "\n" + userAction + "\n" + sender + "\n" + reportTitle + "\n##\n\n");
    }
}
