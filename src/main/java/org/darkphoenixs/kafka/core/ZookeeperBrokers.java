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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * <p>Title: ZookeeperBrokers</p>
 * <p>Description: ZookeeperBrokers</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @since 2015-06-01
 */
public class ZookeeperBrokers {

    public static final Logger logger = LoggerFactory.getLogger(ZookeeperBrokers.class);

    private CuratorFramework _curator;

    private String _zkPath;

    private String _topic;

    public ZookeeperBrokers(ZookeeperHosts zkHosts) {
        _zkPath = zkHosts.getBrokerZkPath();
        _topic = zkHosts.getTopic();
        _curator = CuratorFrameworkFactory.newClient(zkHosts.getBrokerZkStr(), new RetryNTimes(Integer.MAX_VALUE, KafkaConstants.INTERVAL_IN_MS));
        _curator.start();
    }

    public ZookeeperBrokers(String zkStr, String zkPath, String topic) {
        _zkPath = zkPath;
        _topic = topic;
        _curator = CuratorFrameworkFactory.newClient(zkStr, new RetryNTimes(Integer.MAX_VALUE, KafkaConstants.INTERVAL_IN_MS));
        _curator.start();
    }

    /**
     * Get all partitions with their current leaders
     */
    public String getBrokerInfo() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get partitions number
     */
    public int getNumPartitions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * get /brokers/topics/distributedTopic/partitions/1/state {
     * "controller_epoch":4, "isr":[ 1, 0 ], "leader":1, "leader_epoch":1,
     * "version":1 }
     *
     * @param partition
     * @return leader partition number
     */
    public int getLeaderFor(long partition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * [zk: localhost:2181(CONNECTED) 56] get /brokers/ids/0 {
     * "host":"localhost", "jmx_port":9999, "port":9092, "version":1 }
     *
     * @param contents
     * @return broker host
     */
    public String getBrokerHost(byte[] contents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get partition path
     */
    public String partitionPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get broker path
     */
    public String brokerPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Close curator
     */
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
