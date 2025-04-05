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

import java.math.BigDecimal;
import java.util.List;

/**
 * Interface for JSON document manipulation
 * 
 * All methods that take a path parameter throw an exception if the path is incorrectly formed
 * 
 * @author Deepak Arora
 */
public interface Document {

  /**
   * Returns a boolean specifying if this document is a typed document
   */
  boolean isTyped();

  /**
   * Returns the type of the document
   */
  String getType();

  /**
   * Returns the data type of the leaf node
   */
  DataType getLeafNodeDataType(String path, String... vargs);

  /**
   * Returns the date type of the leaf node
   */
  DataType getArrayValueLeafNodeDataType(String path, String... vargs);

  /**
   * Sets the type of a document. The model object needs to be already loaded. 
   * Validation against the model will be carried out and an exception thrown if a violation is found.
   */
  void setType(String type);

  /**
   * Sets the type of a document with specified validation type
   * 
   * @param type The document type
   * @param validationType The validation type to use
   */
  void setType(String type, Constants.VALIDATION_TYPE validationType);

  /**
   * Empty the contents of the document
   */
  void empty();

  /**
   * Delete the specified list of paths from the document
   * <p>
   * Throws an exception if the path is not found in the associated model document if document is typed or
   * if the name in name value pair is not of the right type
   *
   * @param pathsToDelete the list of paths
   */
  void deletePaths(List<String> pathsToDelete);

  /**
   * Delete the specified path from the document. Does nothing if the path is not found. The path specified
   * can be any path including pointing to a leaf, complex or an array node
   * <p>
   * Throws an exception if the path is not found in the associated model document
   *
   * @param path  the path
   * @param vargs the values to replace the % characters in path
   */
  void deletePath(String path, String... vargs);

  /**
   * Gets the size of the array at the path specified. The path specified has to be of array type in the json.
   * 
   * @param path  the path to the array
   * @param vargs the values to replace the % characters in path
   * @return the size of the array
   */
  int getArraySize(String path, String... vargs);

  /**
   * Gets the index of the array element that has the filter field equals the value specified
   * 
   * @param path  path to the array
   * @param vargs the values to replace the % characters in path
   * @return the index of the array element that contains the filter field = filter value
   */
  int getArrayIndex(String path, String... vargs);

  /**
   * Get the JSON content as a string
   * 
   * @return the JSON string
   */
  String getJson();

  /**
   * Get the JSON content as a pretty-printed string
   * 
   * @return the formatted JSON string
   */
  String getPrettyPrintJson();

  /**
   * Get a boolean value at the specified path
   * 
   * @param path  the path
   * @param vargs the values to replace the % characters in path
   * @return the boolean value
   */
  Boolean getBoolean(String path, String... vargs);

  /**
   * Get a string value at the specified path
   * 
   * @param path  the path
   * @param vargs the values to replace the % characters in path
   * @return the string value
   */
  String getString(String path, String... vargs);

  /**
   * Get an integer value at the specified path
   * 
   * @param path  the path
   * @param vargs the values to replace the % characters in path
   * @return the integer value
   */
  Integer getInteger(String path, String... vargs);

  /**
   * Get a long value at the specified path
   * 
   * @param path  the path
   * @param vargs the values to replace the % characters in path
   * @return the long value
   */
  Long getLong(String path, String... vargs);

  /**
   * Get a BigDecimal value at the specified path
   * 
   * @param path  the path
   * @param vargs the values to replace the % characters in path
   * @return the BigDecimal value
   */
  BigDecimal getBigDecimal(String path, String... vargs);
  
  /**
   * Get a date value at the specified path
   * 
   * @param path  the path
   * @param vargs the values to replace the % characters in path
   * @return the date value as string
   */
  String getDate(String path, String... vargs);

  /**
   * Set a boolean value at the specified path
   * 
   * @param path  the path
   * @param value the value to set
   * @param vargs the values to replace the % characters in path
   */
  void setBoolean(String path, boolean value, String... vargs);

  /**
   * Set a string value at the specified path
   * 
   * @param path  the path
   * @param value the value to set
   * @param vargs the values to replace the % characters in path
   */
  void setString(String path, String value, String... vargs);

  /**
   * Set an integer value at the specified path
   * 
   * @param path  the path
   * @param value the value to set
   * @param vargs the values to replace the % characters in path
   */
  void setInteger(String path, int value, String... vargs);

  /**
   * Set a long value at the specified path
   * 
   * @param path  the path
   * @param value the value to set
   * @param vargs the values to replace the % characters in path
   */
  void setLong(String path, long value, String... vargs);

  /**
   * Set a BigDecimal value at the specified path
   * 
   * @param path  the path
   * @param value the value to set
   * @param vargs the values to replace the % characters in path
   */
  void setBigDecimal(String path, BigDecimal value, String... vargs);

  /**
   * Set a date value at the specified path
   * 
   * @param path  the path
   * @param value the date value as string
   * @param vargs the values to replace the % characters in path
   */
  void setDate(String path, String value, String... vargs);

  /**
   * Compare this document with another document
   * 
   * @param doc the document to compare with
   * @param ignoreExtraFields if true, fields in this document that are not in the other document are ignored
   * @return list of differences
   */
  List<DiffInfo> getDifferences(Document doc, boolean ignoreExtraFields);

  /**
   * Flatten the document into a list of paths
   * 
   * @return list of paths in the document
   */
  List<String> flatten();

  /**
   * Flatten the document into a list of path-value pairs
   * 
   * @return list of path-value pairs in the document
   */
  List<PathValue> flattenWithValues();

  /**
   * Return a new document with content from the specified path
   * 
   * @param path the path to extract
   * @param returnTypedDocument if true and this document is typed, return a typed document
   * @param includeFullPath if true, include the full path in the returned document
   * @return the new document
   */
  Document getContent(String path, boolean returnTypedDocument, boolean includeFullPath, String... vargs);

  /**
   * Copy content from another document
   * 
   * @param fromDoc the document to copy from
   * @param fromPath the path in the from document
   * @param toPath the path in this document
   * @param vargs the values to replace the % characters in path
   */
  void setContent(Document fromDoc, String fromPath, String toPath, String... vargs);

  /**
   * Merge content from another document
   * 
   * @param fromDoc the document to merge from
   * @param deletePathsInToDoc paths to delete in this document before merging
   */
  void merge(Document fromDoc, List<String> deletePathsInToDoc);
}