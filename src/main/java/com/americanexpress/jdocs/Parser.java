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

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for JSON paths
 * 
 * @author Deepak Arora
 */
class Parser {

  /**
   * Parse a JSON path into tokens
   * 
   * @param path The JSON path to parse
   * @return List of tokens
   */
  public static List<Token> getTokens(String path) {
    List<String> strTokens = getStringTokens(path);
    return getTokens(strTokens);
  }

  private static List<Token> getTokens(List<String> strTokens) {
    List<Token> tokens = new ArrayList<>();
    int size = strTokens.size();

    for (int i = 0; i < size; i++) {
      String strToken = strTokens.get(i);
      boolean isLeaf = (i == (size - 1));

      int first = isPresent(strToken, '[');
      if (first != -1) {
        tokens.add(getArrayToken(strToken, first, isLeaf));
      } else {
        String s = removeEscapeChars(strToken, '\\', '.', '[', ']', '=');
        tokens.add(new Token(s, isLeaf));
      }
    }

    return tokens;
  }

  private static ArrayToken getArrayToken(String s, int first, boolean isLeaf) {
    String name = removeEscapeChars(s.substring(0, first), '\\', '.', '[', ']', '=');

    if (s.charAt(first + 1) == ']') {
      // Empty array token
      return new ArrayToken(name, isLeaf);
    }

    int pos = s.lastIndexOf(']');
    String content = s.substring(first + 1, pos);
    pos = isPresent(content, '=');
    
    if (pos != -1) {
      // Key-value pair
      String key = removeEscapeChars(content.substring(0, pos), '\\', '.', '[', ']', '=');
      String value = removeEscapeChars(content.substring(pos + 1), '\\', '.', '[', ']', '=');
      return new ArrayToken(name, key, value, isLeaf);
    } else {
      // Array index
      content = removeEscapeChars(content, '\\', '.', '[', ']', '=');
      return new ArrayToken(name, Integer.parseInt(content), isLeaf);
    }
  }

  private static int isPresent(String s, char symbol) {
    int start = 0;
    while (start < s.length()) {
      int i = s.indexOf(symbol, start);
      if (i != -1) {
        if (!isEscaped(s, i, '\\')) {
          return i;
        }
        start = i + 1;
      } else {
        break;
      }
    }
    return -1;
  }

  private static boolean isEscaped(String s, int pos, char escapeChar) {
    if (pos == 0) {
      return false;
    }

    int count = 0;
    int i = pos - 1;
    while (i >= 0 && s.charAt(i) == escapeChar) {
      count++;
      i--;
    }
    
    return (count % 2) == 1;
  }

  private static List<String> getStringTokens(String path) {
    List<String> tokens = new ArrayList<>();
    if (path == null || path.isEmpty()) {
      return tokens;
    }

    // Remove $ prefix if present
    if (path.startsWith("$.")) {
      path = path.substring(2);
    } else if (path.startsWith("$")) {
      path = path.substring(1);
    }

    StringBuilder sb = new StringBuilder();
    int i = 0;

    while (i < path.length()) {
      char c = path.charAt(i);
      if (c == '.' && !isEscaped(path, i, '\\')) {
        if (sb.length() > 0) {
          tokens.add(sb.toString());
          sb.setLength(0);
        }
      } else {
        sb.append(c);
      }
      i++;
    }

    if (sb.length() > 0) {
      tokens.add(sb.toString());
    }

    return tokens;
  }

  private static String removeEscapeChars(String s, char escapeChar, char... chars) {
    if (s == null || s.isEmpty()) {
      return s;
    }

    StringBuilder sb = new StringBuilder(s.length());
    boolean escaped = false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      
      if (escaped) {
        boolean skip = false;
        for (char ch : chars) {
          if (c == ch) {
            skip = true;
            break;
          }
        }
        
        if (!skip) {
          sb.append(escapeChar);
        }
        
        sb.append(c);
        escaped = false;
      } else if (c == escapeChar) {
        escaped = true;
      } else {
        sb.append(c);
      }
    }

    if (escaped) {
      sb.append(escapeChar);
    }

    return sb.toString();
  }
}