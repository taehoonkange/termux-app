package com.termux.shared.termux.data;

import junit.framework.TestCase;

import java.util.LinkedHashSet;

public class TermuxUrlUtilsTest extends TestCase {
    /**
     * Purpose: Check URI generic syntax
     * Input: "Example URI generic syntax: https://username:password@host:0000/path/path2?query=1#fragment & https://host/path?query1=1;query2=2;query3=3#fragment"
     * Expected: ["https://username:password@host:0000/path/path2?query=1#fragment", "https://host/path?query1=1;query2=2;query3=3#fragment"]
     * https://en.wikipedia.org/wiki/URL
     */
    public void testExtractUrlsURIGenericSyntax() {
        String genericURI = "https://username:password@host:0000/path/path2?query=1#fragment";
        String genericURIWithLongQuery = "https://host/path?query1=1;query2=2;query3=3#fragment";
        LinkedHashSet<CharSequence> result = TermuxUrlUtils.extractUrls("Example URI generic syntax: " + genericURI + " & " + genericURIWithLongQuery);
        assertTrue(result.contains(genericURI));
        assertTrue(result.contains(genericURIWithLongQuery));
        assertEquals(result.size(), 2);
    }

}
