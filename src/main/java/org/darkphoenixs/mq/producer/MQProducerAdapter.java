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
package org.darkphoenixs.mq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.darkphoenixs.kafka.codec.KafkaMessageEncoder;
import org.darkphoenixs.kafka.pool.MessageSenderPool;
import org.darkphoenixs.mq.codec.MQMessageEncoder;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.util.MQ_TYPE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Destination;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * The type Mq producer adapter.
 *
 * @param <T> the type parameter
 */
public abstract class MQProducerAdapter<T> implements MQProducer<T> {

    /**
     * The Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /* activemq */
    private JmsTemplate activemqTemplate;

    private Destination activemqDestination;

    /* activemq */
    /* kafka */
    private MessageSenderPool<byte[], byte[]> kafkaMessageSenderPool;

    /* kafka */
    /* rocketmq */
    private DefaultMQProducer rocketmqDefaultProducer;

    private TransactionMQProducer rocketmqTransactionProducer;

    /* rocketmq */
    /* common */
    private MQMessageEncoder<T> messageEncoder;

    private String topic;

    private String producerKey;

    /* common */
    /**
     * The mq type
     */
    private MQ_TYPE type;

    /**
     * Gets activemq template.
     *
     * @return the activemq template
     */
    public JmsTemplate getActivemqTemplate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets activemq template.
     *
     * @param activemqTemplate the activemq template
     */
    public void setActivemqTemplate(JmsTemplate activemqTemplate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets activemq destination.
     *
     * @return the activemq destination
     */
    public Destination getActivemqDestination() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets activemq destination.
     *
     * @param activemqDestination the activemq destination
     */
    public void setActivemqDestination(Destination activemqDestination) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets kafka message sender pool.
     *
     * @return the kafka message sender pool
     */
    public MessageSenderPool<byte[], byte[]> getKafkaMessageSenderPool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets kafka message sender pool.
     *
     * @param kafkaMessageSenderPool the kafka message sender pool
     */
    public void setKafkaMessageSenderPool(MessageSenderPool<byte[], byte[]> kafkaMessageSenderPool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets rocketmq default producer.
     *
     * @return the rocketmq default producer
     */
    public DefaultMQProducer getRocketmqDefaultProducer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets rocketmq default producer.
     *
     * @param rocketmqDefaultProducer the rocketmq default producer
     */
    public void setRocketmqDefaultProducer(DefaultMQProducer rocketmqDefaultProducer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets rocketmq transaction producer.
     *
     * @return the rocketmq transaction producer
     */
    public TransactionMQProducer getRocketmqTransactionProducer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets rocketmq transaction producer.
     *
     * @param rocketmqTransactionProducer the rocketmq transaction producer
     */
    public void setRocketmqTransactionProducer(TransactionMQProducer rocketmqTransactionProducer) {
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

    /**
     * Gets mq type.
     *
     * @return the mq type
     */
    public String getType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets mq type.
     *
     * <p>Note: Must be last set!</p>
     *
     * @param type the mq type
     * @throws MQException the mq exception
     */
    public void setType(String type) throws MQException {
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
     * Batch send.
     *
     * @param messages the messages
     * @throws MQException the mq exception
     */
    public void batchSend(List<T> messages) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Init.
     *
     * @throws MQException the mq exception
     */
    private void initProducer() throws MQException {
        switch(type) {
            case KAFKA:
                if (topic == null || messageEncoder == null || kafkaMessageSenderPool == null)
                    throw new MQException("Topic & MessageEncoder & KafkaMessageSenderPool must not null!");
                org.darkphoenixs.kafka.producer.AbstractProducer<String, T> kafkaAbstractProducer = new org.darkphoenixs.kafka.producer.AbstractProducer<String, T>() {

                    @Override
                    protected T doSend(T message) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                };
                org.darkphoenixs.kafka.core.KafkaMessageTemplate<String, T> kafkaMessageTemplate = new org.darkphoenixs.kafka.core.KafkaMessageTemplate<String, T>();
                kafkaMessageTemplate.setMessageSenderPool(kafkaMessageSenderPool);
                kafkaMessageTemplate.setEncoder(new KafkaMessageEncoder<String, T>() {

                    @Override
                    public byte[] encodeKey(String key) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public byte[] encodeVal(T val) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public List<byte[]> batchEncode(List<T> message) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public Map<byte[], byte[]> batchEncode(Map<String, T> messages) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                });
                org.darkphoenixs.kafka.core.KafkaDestination kafkaDestination = new org.darkphoenixs.kafka.core.KafkaDestination(topic);
                kafkaAbstractProducer.setMessageTemplate(kafkaMessageTemplate);
                kafkaAbstractProducer.setDestination(kafkaDestination);
                kafkaAbstractProducer.setProducerKey(producerKey);
                producerConcurrentMap.put(type, kafkaAbstractProducer);
                break;
            case ROCKETMQ:
                if (topic == null || messageEncoder == null || (rocketmqDefaultProducer == null && rocketmqTransactionProducer == null))
                    throw new MQException("Topic & MessageEncoder & (RocketmqDefaultProducer | RocketmqTransactionProducer) must not null!");
                org.darkphoenixs.rocketmq.producer.AbstractProducer<T> rocketmqAbstractProducer = new org.darkphoenixs.rocketmq.producer.AbstractProducer<T>() {

                    @Override
                    protected T doSend(T message) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    protected List<T> doSend(List<T> messages) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                };
                rocketmqAbstractProducer.setTopic(topic);
                rocketmqAbstractProducer.setMessageEncoder(messageEncoder);
                rocketmqAbstractProducer.setDefaultMQProducer(rocketmqDefaultProducer);
                rocketmqAbstractProducer.setTransactionMQProducer(rocketmqTransactionProducer);
                rocketmqAbstractProducer.setProducerKey(producerKey);
                producerConcurrentMap.put(type, rocketmqAbstractProducer);
                break;
            case ACTIVEMQ:
                if (activemqDestination == null || activemqTemplate == null)
                    throw new MQException("ActivemqDestination & ActivemqTemplate must not null!");
                org.darkphoenixs.activemq.producer.AbstractProducer<T> activemqAbstractProducer = new org.darkphoenixs.activemq.producer.AbstractProducer<T>() {

                    @Override
                    protected Object doSend(T message) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                };
                activemqAbstractProducer.setDestination(activemqDestination);
                activemqAbstractProducer.setJmsTemplate(activemqTemplate);
                activemqAbstractProducer.setProducerKey(producerKey);
                producerConcurrentMap.put(type, activemqAbstractProducer);
                break;
            default:
                throw new MQException("MQ type non-exist default!");
        }
    }

    /**
     * Do send t.
     *
     * @param message the message
     * @return the t
     * @throws MQException the mq exception
     */
    protected abstract T doSend(T message) throws MQException;

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
     * Gets producer instance.
     *
     * @return the producer instance
     */
    public MQProducer<T> getProducerInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final ConcurrentMap<MQ_TYPE, MQProducer<T>> producerConcurrentMap = new ConcurrentHashMap<MQ_TYPE, MQProducer<T>>();
}
