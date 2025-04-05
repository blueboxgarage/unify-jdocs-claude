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
 * Error information tuple
 * 
 * @author Deepak Arora
 */
public class ErrorTuple {

  private String errorCode;
  private String errorMessage;
  private String errorDetails;
  private boolean retryable = false;

  public ErrorTuple() {
    // do nothing
  }

  public ErrorTuple(String errorCode, String errorMessage, String errorDetails) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.errorDetails = errorDetails;
  }

  public ErrorTuple(String errorCode, String errorMessage, String errorDetails, boolean retryable) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.errorDetails = errorDetails;
    this.retryable = retryable;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(String errorDetails) {
    this.errorDetails = errorDetails;
  }

  public boolean isRetryable() {
    return retryable;
  }

  public void setRetryable(boolean retryable) {
    this.retryable = retryable;
  }

  @Override
  public String toString() {
    return "ErrorTuple{" +
        "errorCode='" + errorCode + '\'' +
        ", errorMessage='" + errorMessage + '\'' +
        ", errorDetails='" + errorDetails + '\'' +
        ", retryable=" + retryable +
        '}';
  }
}