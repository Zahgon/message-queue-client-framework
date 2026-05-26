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
package org.darkphoenixs.kafka.pool;

import kafka.common.OffsetAndMetadata;
import kafka.common.TopicAndPartition;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.serializer.Decoder;
import kafka.serializer.DefaultDecoder;
import kafka.utils.VerifiableProperties;
import org.darkphoenixs.kafka.core.*;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.util.RefleTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>Title: KafkaMessageReceiverPool</p>
 * <p>Description: Kafka消息接受线程池</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @since 2015-06-01
 */
public class KafkaMessageReceiverPool<K, V> implements MessageReceiverPool<K, V> {

    private static final String tagger = "KafkaMessageReceiverPool";

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageReceiverPool.class);

    /**
     * consumer
     */
    protected ConsumerConnector consumer;

    /**
     * pool
     */
    protected ExecutorService pool;

    /**
     * props
     */
    protected Properties props = new Properties();

    /**
     * The Running.
     */
    protected AtomicBoolean running = new AtomicBoolean(false);

    /**
     * messageAdapter
     */
    private KafkaMessageAdapter<?, ?> messageAdapter;

    /**
     * destination
     */
    private KafkaDestination destination;

    /**
     * poolSize
     */
    private int poolSize;

    /**
     * config
     */
    private Resource config;

    /**
     * retryCount
     */
    private int retryCount = 3;

    /**
     * receiverRetry
     */
    private KafkaMessageReceiverRetry<MessageAndMetadata<K, V>> receiverRetry;

    /**
     * keyDecoder
     */
    private Class<?> keyDecoderClass = DefaultDecoder.class;

    /**
     * valDecoder
     */
    private Class<?> valDecoderClass = DefaultDecoder.class;

    /**
     * threadFactory
     */
    private ThreadFactory threadFactory;

    /**
     * Init threadFactory.
     */
    public KafkaMessageReceiverPool() {
    }

    /**
     * @return the threadFactory
     */
    public ThreadFactory getThreadFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param threadFactory the threadFactory to set
     */
    public void setThreadFactory(ThreadFactory threadFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public KafkaDestination getDestination() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setDestination(KafkaDestination destination) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the zookeeperStr
     */
    public String getZookeeperStr() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param zookeeperStr the zookeeperStr to set
     */
    public void setZookeeperStr(String zookeeperStr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the autoCommit
     */
    public Boolean getAutoCommit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param autoCommit the autoCommit to set
     */
    public void setAutoCommit(boolean autoCommit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the retryCount
     */
    public int getRetryCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Note: AutoCommit is false to take effect.
     *
     * @param retryCount the retryCount to set
     */
    public void setRetryCount(int retryCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the props
     */
    public Properties getProps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param props the props to set
     */
    public void setProps(Properties props) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the poolSize
     */
    public int getPoolSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param poolSize the poolSize to set
     */
    public void setPoolSize(int poolSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the config
     */
    public Resource getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param config the config to set
     */
    public void setConfig(Resource config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the keyDecoderClass
     */
    public Class<?> getKeyDecoderClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param keyDecoderClass the keyDecoderClass to set
     */
    public void setKeyDecoderClass(Class<?> keyDecoderClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the valDecoderClass
     */
    public Class<?> getValDecoderClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param valDecoderClass the valDecoder to set
     */
    public void setValDecoderClass(Class<?> valDecoderClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the messageAdapter
     */
    public KafkaMessageAdapter<?, ?> getMessageAdapter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param messageAdapter the messageAdapter to set
     */
    public void setMessageAdapter(KafkaMessageAdapter<?, ?> messageAdapter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get a receiver from the pool (just only create a lower-level receiver).
     *
     * @return a receiver instance
     */
    @Override
    public KafkaMessageReceiver<K, V> getReceiver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return a receiver back to pool.
     */
    @Override
    public void returnReceiver(KafkaMessageReceiver<K, V> receiver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void init() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void destroy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized boolean isRunning() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Receiver thread to receive message.
     */
    class ReceiverThread implements Runnable {

        private KafkaStream<K, V> stream;

        private KafkaMessageAdapter<?, ?> adapter;

        public ReceiverThread(KafkaStream<K, V> stream, KafkaMessageAdapter<?, ?> adapter) {
            this.stream = stream;
            this.adapter = adapter;
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
