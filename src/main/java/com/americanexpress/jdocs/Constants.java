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

/**
 * Constants used throughout the jdocs library
 * 
 * @author Deepak Arora
 */
public class Constants {
    // Base constants
    public static final String UTC_TZ = "UTC";
    public static final String GMT_TZ = "GMT";
    public static final String UNIFY_TS_FMT = "uuuu-MMM-dd HH:mm:ss.SSS VV";
    public static final String SPLUNK_TS_FMT = "uuuuMMdd'T'HHmmss.SSS VV";
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final String EMPTY = "";
    public static final String SINGLE_SPACE = " ";
    public static final String UNIFY_DATE_FORMAT = "uuuu-MMM-dd";
    
    // JDocs validation types
    public enum VALIDATION_TYPE {
        ALL_DATA_PATHS,
        ONLY_MODEL_PATHS,
        ONLY_AT_READ_WRITE
    }
}