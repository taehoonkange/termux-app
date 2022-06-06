package com.termux.shared.file;

import android.util.Log;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.File;

public class FileUtilsTest extends TestCase {


    /**
     * Purpose: Check string path is null or empty
     * Input: getCanonicalPath(null, null), getCanonicalPath("", null)
     * Expected:
     *      getCanonicalPath(null, null)-> "/"
     *      getCanonicalPath("", null)   -> "/"
     */

    public void testgetCanonicalEmptyPath(){
        assertEquals(FileUtils.getCanonicalPath(null,null), "/");
        assertEquals(FileUtils.getCanonicalPath("",null), "/");

    }
    /**
     * Purpose: Check string path is Absolute Path
     * Input: getCanonicalPath("/path", null), getCanonicalPath("/path", "prefixForNonAbsolutePath")
     * Expected:
     *      getCanonicalPath("/path", null)-> "/path"
     *      getCanonicalPath("/path", "prefixForNonAbsolutePath")   -> "/path"
     */

    public void testgetCanonicalAbsolutePath(){

        //
        assertEquals(FileUtils.getCanonicalPath("/path",null), "/path");
        assertEquals(FileUtils.getCanonicalPath("/path","prefixForNonAbsolutePath"), "/path");

    }
    /**
     * Purpose: Check when string is non-absolute Path
     * Input: getCanonicalPath("/path", null), getCanonicalPath("/path", "prefixForNonAbsolutePath")
     * Expected:
     *      getCanonicalPath("path", null)-> "/path"
     *      getCanonicalPath("path", "prefixForNonAbsolutePath")   -> "/Users/.../path"
     */

    public void testgetCanonicalNonAbsolutePath(){

       assertEquals(FileUtils.getCanonicalPath("path","prefixForNonAbsolute"), new File("prefixForNonAbsolute/path").getAbsolutePath());
       assertEquals(FileUtils.getCanonicalPath("path",null), "/path");

    }


}
