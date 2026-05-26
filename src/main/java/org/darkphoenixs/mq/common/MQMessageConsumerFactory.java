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
package org.darkphoenixs.mq.common;

import org.darkphoenixs.mq.consumer.MQConsumer;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.factory.MQConsumerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>Title: MQMessageConsumerFactory</p>
 * <p>Description: 消息消费者工厂</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @see MQConsumerFactory
 * @since 2015-06-01
 */
public final class MQMessageConsumerFactory implements MQConsumerFactory {

    /**
     * instance
     */
    private static final AtomicReference<MQMessageConsumerFactory> instance = new AtomicReference<MQMessageConsumerFactory>();

    /**
     * logger
     */
    protected Logger logger = LoggerFactory.getLogger(MQMessageConsumerFactory.class);

    /**
     * consumers
     */
    private MQConsumer<?>[] consumers;

    /**
     * consumerCache
     */
    private ConcurrentHashMap<String, MQConsumer<?>> consumerCache = new ConcurrentHashMap<String, MQConsumer<?>>();

    /**
     * private construction method
     */
    private MQMessageConsumerFactory() {
    }

    /**
     * get singleton instance method
     */
    public synchronized static MQConsumerFactory getInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param consumers the consumers to set
     */
    public void setConsumers(MQConsumer<?>[] consumers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> void addConsumer(MQConsumer<T> consumer) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> MQConsumer<T> getConsumer(String consumerKey) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void init() throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void destroy() throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
