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
 * Main class for initializing the JDocs library
 * 
 * @author Deepak Arora
 */
public class JDocs {

  /**
   * Initialize the JDocs library
   */
  public static void init() {
    init(Constants.VALIDATION_TYPE.ALL_DATA_PATHS);
  }

  /**
   * Initialize the JDocs library with specific validation type
   * 
   * @param validationType The validation type to use
   */
  public static void init(Constants.VALIDATION_TYPE validationType) {
    // Load error codes and messages
    ErrorMap.load();
  }

  /**
   * Initialize the JDocs library for testing
   */
  public static void initTest() {
    ErrorMap.load();
  }

  /**
   * Clean up resources used by the JDocs library
   */
  public static void close() {
    // nothing to do
  }

  /**
   * Clean up resources used by the JDocs library for testing
   */
  public static void closeTest() {
    // nothing to do
  }
}