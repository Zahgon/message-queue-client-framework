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
package org.darkphoenixs.kafka.listener;

import org.darkphoenixs.kafka.consumer.AbstractConsumer;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.factory.MQConsumerFactory;
import org.darkphoenixs.mq.util.RefleTool;

/**
 * <p>KafkaMessageFactoryConsumerListener</p>
 * <p>Kafka消费者工厂监听器</p>
 *
 * @author Victor.Zxy
 * @version 1.3.0
 * @see KafkaMessageListener
 * @since 2016年7月21日
 */
public class KafkaMessageFactoryConsumerListener<K, V> extends KafkaMessageListener<K, V> {

    /**
     * consumerKeyField
     */
    private String consumerKeyField;

    /**
     * consumerFactory
     */
    private MQConsumerFactory consumerFactory;

    /**
     * @return the consumerKeyField
     */
    public String getConsumerKeyField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param consumerKeyField the consumerKeyField to set
     */
    public void setConsumerKeyField(String consumerKeyField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the consumerFactory
     */
    public MQConsumerFactory getConsumerFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param consumerFactory the consumerFactory to set
     */
    public void setConsumerFactory(MQConsumerFactory consumerFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onMessage(K key, V val) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
