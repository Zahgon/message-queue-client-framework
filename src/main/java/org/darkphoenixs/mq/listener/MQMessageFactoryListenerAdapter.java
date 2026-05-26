/*
 * Copyright (c) 2018. Dark Phoenixs (Open-Source Organization).
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
package org.darkphoenixs.mq.listener;

import org.darkphoenixs.mq.consumer.MQConsumerAdapter;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.factory.MQConsumerFactory;
import org.darkphoenixs.mq.util.RefleTool;
import java.util.Map;

/**
 * The type Mq message factory consumer listener.
 *
 * @param <T> the type parameter
 */
public class MQMessageFactoryListenerAdapter<T> extends MQMessageListenerAdapter<T> {

    /**
     * consumerKeyField
     */
    private String consumerKeyField;

    /**
     * consumerFactory
     */
    private MQConsumerFactory consumerFactory;

    /**
     * Gets consumer key field.
     *
     * @return the consumer key field
     */
    public String getConsumerKeyField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets consumer key field.
     *
     * @param consumerKeyField the consumer key field
     */
    public void setConsumerKeyField(String consumerKeyField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets consumer factory.
     *
     * @return the consumer factory
     */
    public MQConsumerFactory getConsumerFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets consumer factory.
     *
     * @param consumerFactory the consumer factory
     */
    public void setConsumerFactory(MQConsumerFactory consumerFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onMessage(T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onMessageWithKey(String key, T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onMessageWithBatch(Map<String, T> messages) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
