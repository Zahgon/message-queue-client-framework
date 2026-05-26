/*
 * Copyright 2015-2016 Dark Phoenixs (Open-Source Organization).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.darkphoenixs.kafka.core;

/**
 * <p>Title: ZookeeperHosts</p>
 * <p>Description: ZookeeperHosts</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @since 2015-06-01
 */
public class ZookeeperHosts {

    private String topic = null;

    private String brokerZkStr = null;

    private String brokerZkPath = null;

    private String DEFAULT_ZK_ROOT = KafkaConstants.DEFAULT_ZK_ROOT;

    private int refreshFreqSecs = KafkaConstants.DEFAULT_REFRESH_FRE_SEC;

    public ZookeeperHosts(String brokerZkStr, String topic) {
        this.topic = topic;
        this.brokerZkStr = brokerZkStr;
        this.brokerZkPath = DEFAULT_ZK_ROOT;
    }

    public ZookeeperHosts(String brokerZkStr, String brokerZkPath, String topic) {
        this.topic = topic;
        this.brokerZkStr = brokerZkStr;
        this.brokerZkPath = brokerZkPath;
    }

    public String getBrokerZkStr() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBrokerZkStr(String brokerZkStr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getBrokerZkPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBrokerZkPath(String brokerZkPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getRefreshFreqSecs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRefreshFreqSecs(int refreshFreqSecs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getTopic() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTopic(String topic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
