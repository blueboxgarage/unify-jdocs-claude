/*
 * Copyright 2020 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.americanexpress.jdocs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * Utility methods for jdocs
 * 
 * @author Deepak Arora
 */
public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * Wrapping function over Java sleep to throws a JdocException
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            throw new JdocException("base_err_4", ex);
        }
    }

    /**
     * Checks if the string value passed is null or empty
     * <p>
     * If string consists of only spaces, it is considered as empty
     *
     * @param s The string to check
     * @return True if string passed is null or empty else false
     */
    public static boolean isNullOrEmpty(String s) {
        return (s == null) || (s.trim().isEmpty());
    }

    /**
     * Removes all white spaces from a string
     * <p>
     * A whitespace is identified using the Java method Character.isWhiteSpace
     *
     * @param s The string containing white spaces
     * @return The string with white spaces removed
     */
    public static String removeWhiteSpaces(String s) {
        StringBuilder sb = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) {
                sb.setCharAt(j, c);
                j++;
            }
        }
        sb.setLength(j);
        return sb.toString();
    }

    /**
     * Get a formatted time string
     * 
     * @param format The date/time format to use
     * @param zoneId The time zone ID
     * @return The formatted time string
     */
    public static String getTimeStr(String format, String zoneId) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern(format)
                .withResolverStyle(ResolverStyle.STRICT);
        return ZonedDateTime.now(ZoneId.of(zoneId)).format(formatter);
    }

    /**
     * Gets the stack trace of an exception as a string
     * 
     * @param t The throwable to get the stack trace from
     * @param limit The maximum number of lines to return (0 = unlimited)
     * @return The stack trace as a string
     */
    public static String getStackTrace(Throwable t, int limit) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        String s = sw.toString();
        
        if (limit <= 0) {
            return s;
        }
        
        // Limit the number of lines
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String line : s.split(System.getProperty("line.separator"))) {
            sb.append(line).append(System.getProperty("line.separator"));
            count++;
            if (count >= limit) {
                break;
            }
        }
        return sb.toString();
    }
}