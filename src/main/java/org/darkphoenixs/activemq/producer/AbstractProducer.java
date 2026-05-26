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
package org.darkphoenixs.activemq.producer;

import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.producer.MQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * <p>Title: AbstractProducer</p>
 * <p>Description: 生产者抽象类</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @see MQProducer
 * @since 2015-06-01
 */
public abstract class AbstractProducer<T> implements MQProducer<T> {

    /**
     * logger
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * jmsTemplate
     */
    private JmsTemplate jmsTemplate;

    /**
     * destination
     */
    private Destination destination;

    /**
     * @since 1.2.3 producerKey
     */
    private String producerKey;

    /**
     * @return the jmsTemplate
     */
    public JmsTemplate getJmsTemplate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param jmsTemplate the jmsTemplate to set
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the destination
     */
    public Destination getDestination() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Destination destination) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void send(T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getProducerKey() throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param producerKey the producerKey to set
     * @since 1.2.3
     */
    public void setProducerKey(String producerKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: doSend</p>
     * <p>Description: 消息发送方法</p>
     *
     * @param message 消息
     * @return 消息
     * @throws MQException MQ异常
     */
    protected abstract Object doSend(T message) throws MQException;
}
