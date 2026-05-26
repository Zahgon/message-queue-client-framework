/*
 * Copyright (c) 2016. Dark Phoenixs (Open-Source Organization).
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

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.darkphoenixs.kafka.core.*;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.util.MQ_BATCH;
import org.darkphoenixs.mq.util.MQ_MODEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>Title: KafkaMessageNewReceiverPool</p>
 * <p>Description: 新Kafka消息接收线程池</p>
 * <p>
 * <p>采用两种设计模式</p>
 * <li>模式一：数据接收与业务处理在同一线程中（并发取决于队列分区）</li>
 * <li>模式二：接收线程与业务线程分离（异步处理数据）</li>
 *
 * @param <K> the type of kafka message key
 * @param <V> the type of kafka message value
 * @author Victor.Zxy
 * @version 1.4.0
 * @see MessageReceiverPool
 * @since 2016 /7/27
 */
public class KafkaMessageNewReceiverPool<K, V> implements MessageReceiverPool<K, V> {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageNewReceiverPool.class);

    /**
     * The enum Commit.
     */
    public enum COMMIT {

        /**
         * auto commit.
         */
        AUTO_COMMIT,
        /**
         * sync commit.
         */
        SYNC_COMMIT,
        /**
         * async commit.
         */
        ASYNC_COMMIT
    }

    /**
     * The blocking queue.
     */
    protected BlockingQueue<ConsumerRecords<K, V>> blockingQueue;

    /**
     * The Receiver pool.
     */
    protected ExecutorService receivPool;

    /**
     * The Handler pool.
     */
    protected ExecutorService handlePool;

    /**
     * The ReceiverThreads.
     */
    protected List<ReceiverThread> receivThreads = new ArrayList<ReceiverThread>();

    /**
     * The HandleThreads.
     */
    protected List<HandlerThread> handleThreads = new ArrayList<HandlerThread>();

    /**
     * The Running.
     */
    protected AtomicBoolean running = new AtomicBoolean(false);

    /**
     * The Model.
     * <p>
     * Default MODEL_1.
     */
    private MQ_MODEL model = MQ_MODEL.MODEL_1;

    /**
     * The Batch.
     * <p>
     * Default NON_BATCH.
     */
    private MQ_BATCH batch = MQ_BATCH.NON_BATCH;

    /**
     * The Commit.
     * <p>
     * Default AUTO_COMMIT.
     */
    private COMMIT commit = COMMIT.AUTO_COMMIT;

    /**
     * The Props.
     */
    private Properties props = new Properties();

    /**
     * The Config.
     */
    private Resource config;

    /**
     * The Pool size.
     * <p>
     * The size is the consumer thread pool size.
     */
    private int poolSize;

    /**
     * How many multiple is the consumer thread pool size, MODEL_2 to take effect.
     * <p>
     * When MODEL is MODEL_2, the handle thread pool size is (poolSize * handleMultiple + 1).
     */
    private int handleMultiple = 2;

    /**
     * The message receive retry Count.
     * <p>
     * When MQ_BATCH is NON_BATCH to take effect.
     */
    private int retryCount = 3;

    /**
     * The Blocking queue size.
     * <p>
     * When MODEL is MODEL_2 to take effect.
     */
    private int queueSize = 100000;

    /**
     * The Thread sleep time(ms).
     * <p>
     * To prevent the CPU usage is too high.
     */
    private long threadSleep = 0;

    /**
     * The Kafka poll timeout time(ms).
     * <p>
     * Default 2000ms.
     */
    private long pollTimeout = 2000;

    /**
     * The Blocking queue monitor interval(ms).
     * <p>
     * Default 30000ms.
     */
    private long monitorIntervalTime = 30 * 1000;

    /**
     * The Blocking queue monitor percentage(%).
     * <p>
     * Default 50%.
     */
    private int monitorPercentage = 50;

    /**
     * messageAdapter
     */
    private KafkaMessageAdapter<?, ?> messageAdapter;

    /**
     * destination
     */
    private KafkaDestination destination;

    /**
     * receiverRetry
     */
    private KafkaMessageReceiverRetry<ConsumerRecord<K, V>> receiverRetry;

    /**
     * receiverMonitor
     */
    private KafkaMessageReceiverMonitor<ConsumerRecords<K, V>> receiverMonitor;

    /**
     * Gets props.
     *
     * @return the props
     */
    public Properties getProps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets props.
     *
     * @param props the props
     */
    public void setProps(Properties props) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets handle multiple.
     *
     * @return the handle multiple
     */
    public int getHandleMultiple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets handle multiple.
     *
     * @param handleMultiple the handle multiple
     */
    public void setHandleMultiple(int handleMultiple) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets retry count.
     *
     * @return the retry count
     */
    public int getRetryCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets retry count.
     *
     * @param retryCount the retry count
     */
    public void setRetryCount(int retryCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets pool size.
     *
     * @return the pool size
     */
    public int getPoolSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets pool size.
     *
     * @param poolSize the pool size
     */
    public void setPoolSize(int poolSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets queue size.
     *
     * @return the queue size
     */
    public int getQueueSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets queue size.
     *
     * @param queueSize the queue size
     */
    public void setQueueSize(int queueSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets thread sleep.
     *
     * @return the thread sleep
     */
    public long getThreadSleep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets thread sleep.
     *
     * @param threadSleep the thread sleep
     */
    public void setThreadSleep(long threadSleep) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets poll timeout.
     *
     * @return the poll timeout
     */
    public long getPollTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets poll timeout.
     *
     * @param pollTimeout the poll timeout
     */
    public void setPollTimeout(long pollTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets monitor interval time.
     *
     * @return the monitor interval time
     */
    public long getMonitorIntervalTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets monitor interval time.
     *
     * @param monitorIntervalTime the monitor interval time
     */
    public void setMonitorIntervalTime(long monitorIntervalTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets monitor percentage.
     *
     * @return the monitor percentage
     */
    public int getMonitorPercentage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets monitor percentage.
     *
     * @param monitorPercentage the monitor percentage
     */
    public void setMonitorPercentage(int monitorPercentage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets config.
     *
     * @return the config
     */
    public Resource getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets config.
     *
     * @param config the config
     */
    public void setConfig(Resource config) {
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
     * @see KafkaMessageAdapter#setModel(String model)
     */
    @Deprecated
    public void setModel(String model) {
        this.model = MQ_MODEL.valueOf(model);
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
     * @see KafkaMessageAdapter#setBatch(String batch)
     */
    @Deprecated
    public void setBatch(String batch) {
        this.batch = MQ_BATCH.valueOf(batch);
    }

    /**
     * Gets commit.
     *
     * @return the commit
     */
    public String getCommit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets commit.
     *
     * @param commit the commit
     */
    public void setCommit(String commit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets message adapter.
     *
     * @return the message adapter
     */
    public KafkaMessageAdapter<?, ?> getMessageAdapter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets message adapter.
     *
     * @param messageAdapter the message adapter
     */
    public void setMessageAdapter(KafkaMessageAdapter<?, ?> messageAdapter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public String getClientId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets group id.
     *
     * @return the group id
     */
    public String getGroupId() {
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

    @Override
    public KafkaMessageReceiver<K, V> getReceiver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

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
     * The type Receiver thread.
     */
    class ReceiverThread implements Runnable {

        /**
         * The constant tagger.
         */
        public static final String tagger = "ReceiverThread";

        private final AtomicBoolean closed = new AtomicBoolean(false);

        private final KafkaConsumer<K, V> consumer;

        private final KafkaMessageAdapter<?, ?> adapter;

        private final String topic;

        /**
         * Instantiates a new Receiver thread.
         *
         * @param props   the props
         * @param topic   the topic
         * @param adapter the adapter
         */
        public ReceiverThread(Properties props, String topic, KafkaMessageAdapter<?, ?> adapter) {
            this.topic = topic;
            this.adapter = adapter;
            consumer = new KafkaConsumer<K, V>(props);
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shutdown hook which can be called from a separate thread.
         */
        public void shutdown() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The type Handler thread.
     */
    class HandlerThread implements Runnable {

        /**
         * The constant tagger.
         */
        public static final String tagger = "HandlerThread";

        private final AtomicBoolean closed = new AtomicBoolean(false);

        private final KafkaMessageAdapter<?, ?> adapter;

        /**
         * Instantiates a new Handler thread.
         *
         * @param adapter the adapter
         */
        public HandlerThread(KafkaMessageAdapter<?, ?> adapter) {
            this.adapter = adapter;
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shutdown hook which can be called from a separate thread.
         */
        public void shutdown() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Commit offSet.
     *
     * @param consumer consumer
     * @param record   record
     * @param commit   commit
     */
    private void commit(KafkaConsumer<K, V> consumer, ConsumerRecord<K, V> record, COMMIT commit) {
        switch(commit) {
            case SYNC_COMMIT:
                consumer.commitSync(Collections.singletonMap(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1)));
                break;
            case ASYNC_COMMIT:
                consumer.commitAsync(Collections.singletonMap(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1)), offsetCommitCallback);
                break;
            default:
                break;
        }
    }

    /**
     * Batch Commit.
     *
     * @param consumer consumer
     * @param commit   commit
     */
    private void batchCommit(KafkaConsumer<K, V> consumer, COMMIT commit) {
        switch(commit) {
            case // 同步提交
            SYNC_COMMIT:
                consumer.commitSync();
                break;
            case // 异步提交
            ASYNC_COMMIT:
                consumer.commitAsync();
                break;
            default:
                break;
        }
    }

    /**
     * ConsumerRecord.
     *
     * @param consumerRecord
     */
    private void messageReceiveRetry(ConsumerRecord<K, V> consumerRecord) {
        if (receiverRetry != null)
            receiverRetry.receiveMessageRetry(consumerRecord);
    }

    /**
     * Wait a moment.
     *
     * @param ms millisecond
     */
    private void waitAmoment(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * The Offset commit callback.
     */
    protected OffsetCommitCallback offsetCommitCallback = new OffsetCommitCallback() {

        @Override
        public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };
}
