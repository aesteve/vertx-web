/*
 * Copyright 2020 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.vertx.ext.web.handler.sse;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class EventSourceOptions extends HttpClientOptions {

  public final static long DEFAULT_RETRY_PERIOD = 60000;

  private long retryPeriod;

  public EventSourceOptions() {
    super();
    retryPeriod = DEFAULT_RETRY_PERIOD;
  }

  public EventSourceOptions(HttpClientOptions clientOptions) {
    super(clientOptions);
    this.retryPeriod = DEFAULT_RETRY_PERIOD;
  }

  public EventSourceOptions(EventSourceOptions other) {
    super(other);
    this.retryPeriod = other.getRetryPeriod();
  }

  /**
   * Creates a new instance from JSON.
   *
   * @param json the JSON object
   */
  public EventSourceOptions(JsonObject json) {
    super(json);
    EventSourceOptionsConverter.fromJson(json, this);
  }

  public EventSourceOptions setRetryPeriod(long retryPeriod) {
    this.retryPeriod = retryPeriod;
    return this;
  }

  public long getRetryPeriod() {
    return retryPeriod;
  }

  /**
   * Convert to JSON
   *
   * @return the JSON
   */
  public JsonObject toJson() {
    JsonObject json = super.toJson();
    EventSourceOptionsConverter.toJson(this, json);
    return json;
  }

}
