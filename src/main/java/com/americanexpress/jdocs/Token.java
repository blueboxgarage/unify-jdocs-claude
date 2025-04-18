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
 * Token representing a field in a JSON path
 * 
 * @author Deepak Arora
 */
class Token {

  private final String field;
  private final boolean isLeaf;

  public Token(String field, boolean isLeaf) {
    this.field = field;
    this.isLeaf = isLeaf;
  }

  public String getField() {
    return field;
  }

  public boolean isArray() {
    return false;
  }

  public boolean isLeaf() {
    return isLeaf;
  }
}