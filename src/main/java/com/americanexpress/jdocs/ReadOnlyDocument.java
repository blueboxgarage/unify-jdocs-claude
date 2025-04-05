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
 * A wrapper that provides read-only access to a Document
 * 
 * @author Deepak Arora
 */
public class ReadOnlyDocument implements Document {

  private final Document document;

  /**
   * Create a read-only wrapper around a document
   * 
   * @param document The document to wrap
   */
  public ReadOnlyDocument(Document document) {
    this.document = document;
  }

  @Override
  public void deletePath(String path, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void deletePaths(List<String> pathsToDelete) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public boolean isTyped() {
    return document.isTyped();
  }

  @Override
  public String getType() {
    return document.getType();
  }

  @Override
  public DataType getLeafNodeDataType(String path, String... vargs) {
    return document.getLeafNodeDataType(path, vargs);
  }

  @Override
  public DataType getArrayValueLeafNodeDataType(String path, String... vargs) {
    return document.getArrayValueLeafNodeDataType(path, vargs);
  }

  @Override
  public void setType(String type) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void setType(String type, Constants.VALIDATION_TYPE validationType) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void empty() {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public int getArraySize(String path, String... vargs) {
    return document.getArraySize(path, vargs);
  }

  @Override
  public int getArrayIndex(String path, String... vargs) {
    return document.getArrayIndex(path, vargs);
  }

  @Override
  public String getJson() {
    return document.getJson();
  }

  @Override
  public String getPrettyPrintJson() {
    return document.getPrettyPrintJson();
  }

  @Override
  public Boolean getBoolean(String path, String... vargs) {
    return document.getBoolean(path, vargs);
  }

  @Override
  public String getString(String path, String... vargs) {
    return document.getString(path, vargs);
  }

  @Override
  public Integer getInteger(String path, String... vargs) {
    return document.getInteger(path, vargs);
  }

  @Override
  public Long getLong(String path, String... vargs) {
    return document.getLong(path, vargs);
  }

  @Override
  public BigDecimal getBigDecimal(String path, String... vargs) {
    return document.getBigDecimal(path, vargs);
  }

  @Override
  public String getDate(String path, String... vargs) {
    return document.getDate(path, vargs);
  }

  @Override
  public void setBoolean(String path, boolean value, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void setString(String path, String value, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void setInteger(String path, int value, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void setLong(String path, long value, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void setBigDecimal(String path, BigDecimal value, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void setDate(String path, String value, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public List<DiffInfo> getDifferences(Document doc, boolean ignoreExtraFields) {
    return document.getDifferences(doc, ignoreExtraFields);
  }

  @Override
  public List<String> flatten() {
    return document.flatten();
  }

  @Override
  public List<PathValue> flattenWithValues() {
    return document.flattenWithValues();
  }

  @Override
  public Document getContent(String path, boolean returnTypedDocument, boolean includeFullPath, String... vargs) {
    Document contentDoc = document.getContent(path, returnTypedDocument, includeFullPath, vargs);
    return contentDoc != null ? new ReadOnlyDocument(contentDoc) : null;
  }

  @Override
  public void setContent(Document fromDoc, String fromPath, String toPath, String... vargs) {
    throw new JdocException("jdoc_err_19");
  }

  @Override
  public void merge(Document fromDoc, List<String> deletePathsInToDoc) {
    throw new JdocException("jdoc_err_19");
  }
}