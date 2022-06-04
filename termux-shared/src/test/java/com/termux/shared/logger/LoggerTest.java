package com.termux.shared.logger;

import junit.framework.TestCase;

import org.junit.Test;

public class LoggerTest extends TestCase {

    /**
     * Purpose: Check when throwable is null
     * Input: Logger.getMessageAndStackTraceString (null, null), ("message" null)
     * Expected:
     *      (null, null) = null
     *      ("message" null) = "message"
     */
    @Test
    public void testGetMessageAndStackTraceStringForNullThrowable() {
        assertNull(Logger.getMessageAndStackTraceString(null, null));

        String message = "message";
        String result = Logger.getMessageAndStackTraceString(message, null);
        assertEquals(result, message);
    }
}
