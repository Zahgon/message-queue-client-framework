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
package org.darkphoenixs.kafka.core;

import org.darkphoenixs.kafka.codec.KafkaMessageDecoder;
import org.darkphoenixs.kafka.codec.KafkaMessageEncoder;
import org.darkphoenixs.kafka.pool.MessageReceiverPool;
import org.darkphoenixs.kafka.pool.MessageSenderPool;
import org.darkphoenixs.mq.exception.MQException;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: KafkaMessageTemplate</p>
 * <p>Description: Kafka消息模板类</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @since 2015-06-01
 */
public class KafkaMessageTemplate<K, V> {

    /**
     * messageSenderPool
     */
    private MessageSenderPool<byte[], byte[]> messageSenderPool;

    /**
     * messageReceiverPool
     */
    private MessageReceiverPool<byte[], byte[]> messageReceiverPool;

    /**
     * encoder
     */
    private KafkaMessageEncoder<K, V> encoder;

    /**
     * decoder
     */
    private KafkaMessageDecoder<K, V> decoder;

    /**
     * @return the messageSenderPool
     */
    public MessageSenderPool<byte[], byte[]> getMessageSenderPool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param messageSenderPool the messageSenderPool to set
     */
    public void setMessageSenderPool(MessageSenderPool<byte[], byte[]> messageSenderPool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the messageReceiverPool
     */
    public MessageReceiverPool<byte[], byte[]> getMessageReceiverPool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param messageReceiverPool the messageReceiverPool to set
     */
    public void setMessageReceiverPool(MessageReceiverPool<byte[], byte[]> messageReceiverPool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the encoder
     */
    public KafkaMessageEncoder<K, V> getEncoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param encoder the encoder to set
     */
    public void setEncoder(KafkaMessageEncoder<K, V> encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the decoder
     */
    public KafkaMessageDecoder<K, V> getDecoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param decoder the decoder to set
     */
    public void setDecoder(KafkaMessageDecoder<K, V> decoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: send</p>
     * <p>Description: 发送消息</p>
     *
     * @param destination 队列
     * @param message     消息
     */
    public void send(KafkaDestination destination, byte[] message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>sendWithKey</p>
     * <p>发送消息带标识</p>
     *
     * @param destination 队列
     * @param key         标识
     * @param message     消息
     * @since 1.3.0
     */
    public void sendWithKey(KafkaDestination destination, byte[] key, byte[] message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: convertAndSend</p>
     * <p>Description: 转换并发送消息</p>
     *
     * @param destination 队列
     * @param message     消息
     * @throws MQException
     */
    public void convertAndSend(KafkaDestination destination, V message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>convertAndSendWithKey</p>
     * <p>转换并发送消息带标识</p>
     *
     * @param destination 队列
     * @param key         标识
     * @param message     消息
     * @throws MQException
     * @since 1.3.0
     */
    public void convertAndSendWithKey(KafkaDestination destination, K key, V message) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: receive</p>
     * <p>Description: 接收消息</p>
     *
     * @param destination 队列
     * @param partition   分区编号
     * @param beginOffset 起始位置
     * @param readOffset  读取条数
     * @return 消息列表
     * @throws MQException
     */
    public List<byte[]> receive(KafkaDestination destination, int partition, long beginOffset, long readOffset) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>receiveWithKey</p>
     * <p>接收消息带标识</p>
     *
     * @param destination 队列
     * @param partition   分区编号
     * @param beginOffset 起始位置
     * @param readOffset  读取条数
     * @return 消息列表
     * @throws MQException
     * @since 1.3.0
     */
    public Map<byte[], byte[]> receiveWithKey(KafkaDestination destination, int partition, long beginOffset, long readOffset) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Title: receiveAndConvert</p>
     * <p>Description: 接收并转换消息</p>
     *
     * @param destination 队列
     * @param partition   分区编号
     * @param beginOffset 起始位置
     * @param readOffset  读取条数
     * @return 消息列表
     * @throws MQException
     */
    public List<V> receiveAndConvert(KafkaDestination destination, int partition, long beginOffset, long readOffset) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>receiveWithKeyAndConvert</p>
     * <p>接收带标识并转换消息</p>
     *
     * @param destination 队列
     * @param partition   分区编号
     * @param beginOffset 起始位置
     * @param readOffset  读取条数
     * @return 消息列表
     * @throws MQException
     * @since 1.3.0
     */
    public Map<K, V> receiveWithKeyAndConvert(KafkaDestination destination, int partition, long beginOffset, long readOffset) throws MQException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
