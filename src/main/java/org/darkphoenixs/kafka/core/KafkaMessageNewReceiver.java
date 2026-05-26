/*
 * Copyright (c) 2016. Dark Phoenixs (Open-Source Organization).
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

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import java.util.*;

/**
 * <p>Title: KafkaMessageNewReceiver</p>
 * <p>Description: Kafka消息新接收器</p>
 *
 * @param <K> the type of kafka message key
 * @param <V> the type of kafka message value
 * @author Victor.Zxy
 * @version 1.4.0
 * @see KafkaMessageReceiver
 * @since 2016 /7/27
 */
public class KafkaMessageNewReceiver<K, V> implements KafkaMessageReceiver<K, V> {

    /**
     * The MQConsumer.
     */
    protected final KafkaConsumer<K, V> kafkaConsumer;

    /**
     * Instantiates a new Kafka message new receiver.
     *
     * @param props the props
     */
    public KafkaMessageNewReceiver(Properties props) {
        kafkaConsumer = new KafkaConsumer<K, V>(props);
    }

    @Override
    public synchronized List<V> receive(String topic, int partition, long beginOffset, long readOffset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized Map<K, V> receiveWithKey(String topic, int partition, long beginOffset, long readOffset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized long getLatestOffset(String topic, int partition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized long getEarliestOffset(String topic, int partition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getPartitionCount(String topic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void shutDown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
