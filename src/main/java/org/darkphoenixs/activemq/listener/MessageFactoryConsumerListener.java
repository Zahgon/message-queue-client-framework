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
package org.darkphoenixs.activemq.listener;

import org.darkphoenixs.mq.consumer.MQConsumer;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.factory.MQConsumerFactory;
import org.darkphoenixs.mq.listener.MQMessageListener;
import org.darkphoenixs.mq.util.RefleTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutorService;

/**
 * <p>Title: MessageFactoryConsumerListener</p>
 * <p>Description: 消费者工厂监听器</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @see MQMessageListener
 * @since 2015-06-01
 */
public class MessageFactoryConsumerListener<T> implements MQMessageListener<T> {

    /**
     * logger
     */
    protected Logger logger = LoggerFactory.getLogger(MessageFactoryConsumerListener.class);

    /**
     * consumerKeyField
     */
    private String consumerKeyField;

    /**
     * consumerFactory
     */
    private MQConsumerFactory consumerFactory;

    /**
     * threadPool
     */
    private ExecutorService threadPool;

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

    /**
     * @return the threadPool
     */
    public ExecutorService getThreadPool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param threadPool the threadPool to set
     */
    public void setThreadPool(ExecutorService threadPool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onMessage(final T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
