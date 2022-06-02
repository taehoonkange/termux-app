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

    /**
     * Purpose: Check url that host is IPv6
     * Input: "Example IPv6 host: http://[1111:1111:1:2::4]"
     * Expected: ["http://[1111:1111:1:2::4"]
     * https://en.wikipedia.org/wiki/URL
     */
    public void testExtractUrlsIPv6() {
        String urlIPv6 = "http://[1111:1111:1:2::4]";
        LinkedHashSet<CharSequence> result = TermuxUrlUtils.extractUrls("Example IPv6 host: " + urlIPv6);
        assertTrue(result.contains(urlIPv6));
        assertEquals(result.size(), 1);
    }

    /**
     * Purpose: Check udp url with stream, port number and ip address
     * Input: "Example udp url1: udp://224.1.1.1:9005
     *         Example udp url2: udp://224.1.1.1:9005/20.5.1.200"
     * Expected: ["udp://224.1.1.1:9005", "udp://224.1.1.1:9005/20.5.1.200"]
     * https://www.leadtools.com/help/sdk/v21/multimedia/filters/udp-source-url-syntax.html
     */
    public void testExtractUrlsUDP() {
        String url1 = "udp://224.1.1.1:9005";
        String url2 = "udp://224.1.1.1:9005/20.5.1.200";
        LinkedHashSet<CharSequence> result = TermuxUrlUtils.extractUrls("Example udp url1: " + url1
            + "\nExample udp url2: " + url2);
        assertTrue(result.contains(url1));
        assertTrue(result.contains(url2));
        assertEquals(result.size(), 2);
    }

}
