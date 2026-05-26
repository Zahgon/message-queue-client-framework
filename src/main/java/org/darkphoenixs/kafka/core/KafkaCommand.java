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

import kafka.admin.TopicCommand;
import kafka.admin.TopicCommand.TopicCommandOptions;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;

/**
 * <p>Title: KafkaCommand</p>
 * <p>Description: Kafka命令类</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @since 2015-06-01
 */
public class KafkaCommand {

    /**
     * 空格
     */
    private static final String space = " ";

    /**
     * 会话超时时间
     */
    private static final int sessionTimeout = 30000;

    /**
     * 连接超时时间
     */
    private static final int connectionTimeout = 30000;

    /**
     * <p>Title: listTopics</p>
     * <p>Description: 查询队列列表操作</p>
     *
     * @param zookeeperStr zookeeper地址
     */
    public static void listTopics(String zookeeperStr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: createTopic</p>
     * <p>Description: 创建队列操作</p>
     *
     * @param zookeeperStr zookeeper地址
     * @param topic        队列名称
     * @param replications 复制个数
     * @param partitions   分区个数
     */
    public static void createTopic(String zookeeperStr, String topic, int replications, int partitions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: describeTopic</p>
     * <p>Description: 查询队列操作</p>
     *
     * @param zookeeperStr zookeeper地址
     * @param topic        队列名称
     */
    public static void describeTopic(String zookeeperStr, String topic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: alterTopic</p>
     * <p>Description: 修改队列操作</p>
     *
     * @param zookeeperStr zookeeper地址
     * @param topic        队列名称
     * @param partitions   分区个数
     */
    public static void alterTopic(String zookeeperStr, String topic, int partitions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: alterTopic</p>
     * <p>Description: 修改队列操作</p>
     *
     * @param zookeeperStr zookeeper地址
     * @param topic        队列名称
     * @param config       配置参数
     */
    public static void alterTopic(String zookeeperStr, String topic, String... config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: alterTopic</p>
     * <p>Description: 修改队列操作</p>
     *
     * @param zookeeperStr zookeeper地址
     * @param topic        队列名称
     * @param partitions   分区个数
     * @param config       配置参数
     */
    public static void alterTopic(String zookeeperStr, String topic, int partitions, String... config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: deleteTopic</p>
     * <p>Description: 删除队列操作</p>
     *
     * @param zookeeperStr zookeeper地址
     * @param topic        队列名称
     */
    public static void deleteTopic(String zookeeperStr, String topic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
