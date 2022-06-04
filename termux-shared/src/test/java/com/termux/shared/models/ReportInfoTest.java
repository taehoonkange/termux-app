package com.termux.shared.models;

import com.termux.shared.markdown.MarkdownUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
