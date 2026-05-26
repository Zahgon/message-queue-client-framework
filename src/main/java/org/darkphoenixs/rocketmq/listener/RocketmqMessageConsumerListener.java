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
package org.darkphoenixs.rocketmq.listener;

import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.darkphoenixs.mq.codec.MQMessageDecoder;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.util.MQ_BATCH;
import org.darkphoenixs.mq.util.MQ_MODEL;
import org.darkphoenixs.rocketmq.consumer.AbstractConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: RocketmqMessageConsumerListener</p>
 * <p>Description: Rocketmq消息监听器实现类</p>
 *
 * @param <T> the type parameter
 * @author Victor
 * @version 1.0
 * @see RocketmqMessageListener
 * @since 2017 /12/10
 */
public class RocketmqMessageConsumerListener<T> extends RocketmqMessageListener<T> {

    /**
     * The Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(RocketmqMessageConsumerListener.class);

    private MQMessageDecoder<T> messageDecoder;

    private AbstractConsumer<T> consumer;

    private MQ_BATCH batch = MQ_BATCH.NON_BATCH;

    private MQ_MODEL model = MQ_MODEL.MODEL_1;

    /**
     * Gets message decoder.
     *
     * @return the message decoder
     */
    public MQMessageDecoder<T> getMessageDecoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets message decoder.
     *
     * @param messageDecoder the message decoder
     */
    public void setMessageDecoder(MQMessageDecoder<T> messageDecoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets consumer.
     *
     * @return the consumer
     */
    public AbstractConsumer<T> getConsumer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets consumer.
     *
     * @param consumer the consumer
     */
    public void setConsumer(AbstractConsumer<T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets batch.
     *
     * @return the batch
     */
    public String getBatch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets batch.
     *
     * @param batch the batch
     */
    public void setBatch(String batch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated
    public void onMessage(T message) throws MQException {
        if (consumer != null)
            consumer.receive(message);
        else
            throw new MQException("Consumer is null !");
        logger.debug("Consume Success, Message : " + message);
    }

    @Deprecated
    public void onMessage(List<T> messages) throws MQException {
        if (consumer != null)
            consumer.receive(messages);
        else
            throw new MQException("Consumer is null !");
        logger.debug("Consume Success, Message size: " + messages.size());
    }

    @Override
    public void onMessage(String key, T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onMessage(Map<String, T> messages) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MessageListener getMessageListener() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * consume.
     *
     * @param messages messages
     * @throws MQException
     */
    private void consume(List<MessageExt> messages) throws MQException {
        switch(batch) {
            case BATCH:
                Map<String, T> identityHashMap = new IdentityHashMap<String, T>();
                for (MessageExt message : messages) identityHashMap.put(message.getKeys(), messageDecoder.decode(message.getBody()));
                onMessage(identityHashMap);
                break;
            case NON_BATCH:
                for (MessageExt message : messages) onMessage(message.getKeys(), messageDecoder.decode(message.getBody()));
                break;
        }
    }

    /**
     * The Message listener concurrently.
     */
    protected MessageListenerConcurrently messageListenerConcurrently = new MessageListenerConcurrently() {

        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    /**
     * The Message listener orderly.
     */
    protected MessageListenerOrderly messageListenerOrderly = new MessageListenerOrderly() {

        @Override
        public ConsumeOrderlyStatus consumeMessage(List<MessageExt> messages, ConsumeOrderlyContext consumeOrderlyContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };
}
