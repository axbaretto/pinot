/**
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
package org.apache.pinot.core.plan.maker;

import java.util.List;
import java.util.concurrent.ExecutorService;
import org.apache.pinot.common.request.BrokerRequest;
import org.apache.pinot.core.data.manager.SegmentDataManager;
import org.apache.pinot.core.indexsegment.IndexSegment;
import org.apache.pinot.core.plan.Plan;
import org.apache.pinot.core.plan.PlanNode;


/**
 * The <code>PlanMaker</code> provides interfaces to make segment level and instance level execution plan.
 */
public interface PlanMaker {

  /**
   * Make segment level {@link PlanNode} which contains execution plan on only one segment.
   *
   * @param indexSegment index segment.
   * @param brokerRequest broker request.
   * @return segment level plan node.
   */
  PlanNode makeInnerSegmentPlan(IndexSegment indexSegment, BrokerRequest brokerRequest);

  /**
   * Make instance level {@link Plan} which contains execution plan on multiple segments.
   *
   * @param segmentDataManagers list of segment data manager.
   * @param brokerRequest broker request.
   * @param executorService executor service.
   * @param timeOutMs time out in milliseconds.
   * @return instance level plan.
   */
  Plan makeInterSegmentPlan(List<SegmentDataManager> segmentDataManagers, BrokerRequest brokerRequest,
      ExecutorService executorService, long timeOutMs);
}
