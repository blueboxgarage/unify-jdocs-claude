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
 * Data types supported in JDocs
 * 
 * @author Deepak Arora
 */
public enum DataType {
  STRING("string"),
  DATE("date"),
  BOOLEAN("boolean"),
  INTEGER("integer"),
  LONG("long"),
  DECIMAL("decimal");

  private final String dataType;

  DataType(String dataType) {
    this.dataType = dataType;
  }

  public String toString() {
    return dataType;
  }
}