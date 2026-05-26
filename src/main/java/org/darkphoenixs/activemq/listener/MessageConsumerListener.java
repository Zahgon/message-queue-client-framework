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
import org.darkphoenixs.mq.listener.MQMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutorService;

/**
 * <p>Title: MessageConsumerListener</p>
 * <p>Description: 消费者监听器</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @see MQMessageListener
 * @since 2015-06-01
 */
public class MessageConsumerListener<T> implements MQMessageListener<T> {

    /**
     * logger
     */
    protected Logger logger = LoggerFactory.getLogger(MessageConsumerListener.class);

    /**
     * messageConsumer
     */
    private MQConsumer<T> consumer;

    /**
     * threadPool
     */
    private ExecutorService threadPool;

    /**
     * @return the consumer
     */
    public MQConsumer<T> getConsumer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param consumer the consumer to set
     */
    public void setConsumer(MQConsumer<T> consumer) {
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
