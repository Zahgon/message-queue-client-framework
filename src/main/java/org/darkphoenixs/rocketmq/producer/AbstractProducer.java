/*
 * Copyright (c) 2017. Dark Phoenixs (Open-Source Organization).
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
package org.darkphoenixs.rocketmq.producer;

import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.darkphoenixs.mq.codec.MQMessageEncoder;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.producer.MQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: AbstractProducer</p>
 * <p>Description: 生产者抽象类</p>
 *
 * @param <T> the type parameter
 * @author Victor
 * @version 1.0
 * @see MQProducer
 * @since 2017 /12/10
 */
public abstract class AbstractProducer<T> implements MQProducer<T> {

    /**
     * The Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private DefaultMQProducer defaultMQProducer;

    private TransactionMQProducer transactionMQProducer;

    private MQMessageEncoder<T> messageEncoder;

    private String topic;

    private String producerKey;

    /**
     * Gets transaction mq producer.
     *
     * @return the transaction mq producer
     */
    public TransactionMQProducer getTransactionMQProducer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets transaction mq producer.
     *
     * @param transactionMQProducer the transaction mq producer
     */
    public void setTransactionMQProducer(TransactionMQProducer transactionMQProducer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets default mq producer.
     *
     * @return the default mq producer
     */
    public DefaultMQProducer getDefaultMQProducer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets default mq producer.
     *
     * @param defaultMQProducer the default mq producer
     */
    public void setDefaultMQProducer(DefaultMQProducer defaultMQProducer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets message encoder.
     *
     * @return the message encoder
     */
    public MQMessageEncoder<T> getMessageEncoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets message encoder.
     *
     * @param messageEncoder the message encoder
     */
    public void setMessageEncoder(MQMessageEncoder<T> messageEncoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getProducerKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets producer key.
     *
     * @param producerKey the producer key
     */
    public void setProducerKey(String producerKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void send(T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Batch send.
     *
     * @param messages the messages
     * @throws MQException the mq exception
     */
    public void batchSend(List<T> messages) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send async.
     *
     * @param message the message
     * @throws MQException the mq exception
     */
    public void sendAsync(T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send one way.
     *
     * @param message the message
     * @throws MQException the mq exception
     */
    public void sendOneWay(T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send with key.
     *
     * @param key     the key
     * @param message the message
     * @throws MQException the mq exception
     */
    public void sendWithKey(String key, T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send with tag.
     *
     * @param key     the key
     * @param tag     the tag
     * @param message the message
     * @throws MQException the mq exception
     */
    public void sendWithTag(String key, String tag, T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send with tx.
     *
     * @param message  the message
     * @param executer the executer
     * @param param    the param
     * @throws MQException the mq exception
     */
    public void sendWithTx(T message, LocalTransactionExecuter executer, Object param) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Do send t.
     *
     * @param message the message
     * @return the t
     * @throws MQException the mq exception
     */
    protected T doSend(T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Do send list.
     *
     * @param messages the messages
     * @return the list
     * @throws MQException the mq exception
     */
    protected List<T> doSend(List<T> messages) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The Message queue selector.
     */
    protected MessageQueueSelector messageQueueSelector = new MessageQueueSelector() {

        @Override
        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };
}
