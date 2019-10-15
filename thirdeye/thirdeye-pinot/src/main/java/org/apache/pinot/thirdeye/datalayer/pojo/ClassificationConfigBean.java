/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.pinot.thirdeye.datalayer.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The configuration for a classification job.
 * The classification is supposed to determine the issue type of the anomalies that are generated by the main anomaly
 * function, which is specified by mainFunctionIdList. Moreover, this configuration provides a list of auxiliary
 * anomaly function ids whose anomalies are used for determining the issue type during the classification.
 */
public class ClassificationConfigBean extends AbstractBean {
  private String name = "";
  private List<Long> mainFunctionIdList = new ArrayList<>();
  private List<Long> auxFunctionIdList = new ArrayList<>();
  private boolean active;
  private Map<String, String> classifierConfig = new HashMap<>();
  private long endTimeWatermark = 0L;


  /**
   * Returns the name of this classification configuration.
   *
   * @return the name of this classification configuration.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this classification configuration.
   *
   * @param name the name of this classification configuration.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the id list of the main functions whose anomalies' issue type will be determined.
   *
   * @return the id list of the main functions whose anomalies' issue type will be determined.
   */
  public List<Long> getMainFunctionIdList() {
    return mainFunctionIdList;
  }

  /**
   * Sets the id list of the main functions whose anomalies' issue type will be determined.
   *
   * @param mainFunctionIdList the id list of the main functions whose anomalies' issue type will be determined.
   */
  public void setMainFunctionIdList(List<Long> mainFunctionIdList) {
    this.mainFunctionIdList = mainFunctionIdList;
  }

  /**
   * Returns the list of ids of auxiliary anomaly functions whose anomalies are used for determining the issue type of
   * the anomalies from main anomaly function.
   *
   * @return the list of ids of auxiliary anomaly functions.
   */
  public List<Long> getAuxFunctionIdList() {
    return auxFunctionIdList;
  }

  /**
   * Sets the list of ids of auxiliary anomaly functions whose anomalies are used for determining the issue type of
   * the anomalies from main anomaly function.
   *
   * @param auxFunctionIdList the list of ids of auxiliary anomaly functions.
   */
  public void setAuxFunctionIdList(List<Long> auxFunctionIdList) {
    this.auxFunctionIdList = auxFunctionIdList;
  }

  /**
   * Returns if this configuration is activated.
   *
   * @return if this configuration is activated.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets if this configuration is activated.
   *
   * @param active if this configuration is activated.
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Returns the configuration, which is given by a map of strings to strings, of classifier.
   *
   * @return the configuration, which is given by a map of strings to strings, of classifier.
   */
  public Map<String, String> getClassifierConfig() {
    return classifierConfig;
  }

  /**
   * Sets the configuration, which should be given by a map of strings to strings, of classifier.
   *
   * @param classifierConfig the configuration, which should be given by a map of strings to strings, of classifier.
   */
  public void setClassifierConfig(Map<String, String> classifierConfig) {
    this.classifierConfig = classifierConfig;
  }

  public long getEndTimeWatermark() {
    return endTimeWatermark;
  }

  public void setEndTimeWatermark(long endTimeWatermark) {
    this.endTimeWatermark = endTimeWatermark;
  }
}
