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

import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.darkphoenixs.kafka.codec.KafkaMessageDecoder;
import org.darkphoenixs.kafka.core.KafkaMessageAdapter;
import org.darkphoenixs.kafka.listener.KafkaMessageConsumerListener;
import org.darkphoenixs.mq.codec.MQMessageDecoder;
import org.darkphoenixs.mq.consumer.MQConsumerAdapter;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.util.MQ_BATCH;
import org.darkphoenixs.mq.util.MQ_MODEL;
import org.darkphoenixs.mq.util.MQ_TYPE;
import org.darkphoenixs.rocketmq.listener.RocketmqMessageConsumerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Mq message consumer listener.
 *
 * @param <T> the type parameter
 */
public class MQMessageListenerAdapter<T> implements MQMessageListener<T> {

    /**
     * The Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(MQMessageListenerAdapter.class);

    /**
     * The Kafka message adapter.
     */
    protected KafkaMessageAdapter<String, T> kafkaMessageAdapter;

    /**
     * The Rocket message listener.
     */
    protected MessageListener rocketMessageListener;

    private MQMessageDecoder<T> messageDecoder;

    private MQConsumerAdapter<T> consumerAdapter;

    private MQ_TYPE type;

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
     * Gets consumer adapter.
     *
     * @return the consumer adapter
     */
    public MQConsumerAdapter<T> getConsumerAdapter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets consumer adapter.
     *
     * @param consumerAdapter the consumer adapter
     */
    public void setConsumerAdapter(MQConsumerAdapter<T> consumerAdapter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets type.
     *
     * @return the type
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

    @Override
    public void onMessage(T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * On message with key.
     *
     * @param key     the key
     * @param message the message
     * @throws MQException the mq exception
     */
    public void onMessageWithKey(String key, T message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * On message with batch.
     *
     * @param messages the messages
     * @throws MQException the mq exception
     */
    public void onMessageWithBatch(Map<String, T> messages) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets kafka message adapter.
     *
     * @return the kafka message adapter
     */
    public KafkaMessageAdapter<String, T> getKafkaMessageAdapter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets rocket message listener.
     *
     * @return the rocket message listener
     */
    public MessageListener getRocketMessageListener() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void initListener() throws MQException {
        switch(type) {
            case KAFKA:
                if (messageDecoder == null)
                    throw new MQException("MessageDecoder must not null!");
                kafkaMessageAdapter = new KafkaMessageAdapter<String, T>();
                kafkaMessageAdapter.setBatch(getBatch());
                kafkaMessageAdapter.setModel(getModel());
                kafkaMessageAdapter.setDecoder(new KafkaMessageDecoder<String, T>() {

                    @Override
                    public String decodeKey(byte[] bytes) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public T decodeVal(byte[] bytes) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public List<T> batchDecode(List<byte[]> bytes) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public Map<String, T> batchDecode(Map<byte[], byte[]> bytes) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                });
                kafkaMessageAdapter.setMessageListener(new KafkaMessageConsumerListener<String, T>() {

                    @Override
                    public void onMessage(String key, T val) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public void onMessage(Map<String, T> messages) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                });
                break;
            case ROCKETMQ:
                if (messageDecoder == null)
                    throw new MQException("MessageDecoder must not null!");
                RocketmqMessageConsumerListener<T> rocketmqMessageConsumerListener = new RocketmqMessageConsumerListener<T>() {

                    @Override
                    public void onMessage(String key, T val) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public void onMessage(Map<String, T> messages) throws MQException {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                };
                rocketmqMessageConsumerListener.setBatch(getBatch());
                rocketmqMessageConsumerListener.setModel(getModel());
                rocketmqMessageConsumerListener.setMessageDecoder(getMessageDecoder());
                rocketMessageListener = rocketmqMessageConsumerListener.getMessageListener();
                break;
            case ACTIVEMQ:
                // nothing
                break;
            default:
                throw new MQException("MQ type non-exist default!");
        }
    }
}
