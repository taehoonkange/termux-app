package com.termux.shared.net.url;

import junit.framework.TestCase;

public class UrlUtilsTest extends TestCase {
    /**
     * Purpose: Check the right form(success)
     * Input: base: "https://github.com", destination: "termux/termux-app"
     * Expected: "https://github.com/termux/termux-app"
     */
    public void testJoinUrlRight() {
        String base = "https://github.com";
        String destination = "termux/termux-app";
        assertEquals(base + "/" + destination, UrlUtils.joinUrl(base, destination, false));
    }

    /**
     * Purpose: Check the wrong form
     * Input: base: "github.com", destination: "termux/termux-app"
     * Expected: null
     */
    public void testJoinUrlWrongForm() {
        String base = "github.com";
        String destination = "termux/termux-app";
        assertNull(UrlUtils.joinUrl(base, destination, false));
    }

    /**
     * Purpose: Check the unknown protocol
     * Input: base: "unknownProtocol://github.com", destination: "termux/termux-app"
     * Expected: null
     */
    public void testJoinUrlUnknownProtocol() {
        String base = "unknownProtocol://github.com";
        String destination = "termux/termux-app";
        assertNull(UrlUtils.joinUrl(base, destination, false));
    }

}
