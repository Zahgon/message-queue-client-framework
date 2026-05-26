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

import org.darkphoenixs.kafka.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>Title: KafkaMessageSenderPool</p>
 * <p>Description: Kafka消息发送连接池</p>
 *
 * @author Victor.Zxy
 * @version 1.0
 * @since 2015-06-01
 */
public class KafkaMessageSenderPool<K, V> implements MessageSenderPool<K, V> {

    private static final String tagger = "KafkaMessageSenderPool";

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageSenderPool.class);

    private static final int defaultSize = Runtime.getRuntime().availableProcessors() * 2 + 1;

    /**
     * freeSender
     */
    protected Semaphore freeSender;

    /**
     * queue
     */
    protected LinkedBlockingQueue<KafkaMessageSender<K, V>> queue;

    /**
     * pool
     */
    protected ExecutorService pool;

    /**
     * closingLock
     */
    protected ReadWriteLock closingLock = new ReentrantReadWriteLock();

    /**
     * props
     */
    protected Properties props = new Properties();

    /**
     * The Running.
     */
    protected AtomicBoolean running = new AtomicBoolean(false);

    /**
     * poolSize
     */
    private int poolSize;

    /**
     * config
     */
    private Resource config;

    /**
     * threadFactory
     */
    private ThreadFactory threadFactory;

    /**
     * Init threadFactory.
     */
    public KafkaMessageSenderPool() {
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
     * @param zkhosts the zkhosts to set
     */
    public void setZkhosts(ZookeeperHosts zkhosts) {
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
     * @return the brokerStr
     */
    public String getBrokerStr() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param brokerStr the brokerStr to set
     */
    public void setBrokerStr(String brokerStr) {
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

    @Override
    public synchronized void init() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get a sender from the pool within the given timeout
     *
     * @return a sender instance
     */
    @Override
    public KafkaMessageSender<K, V> getSender() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return a sender back to pool.
     */
    @Override
    public void returnSender(KafkaMessageSender<K, V> sender) {
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
     * Init Task Call Back.
     */
    class InitTask implements Callable<Boolean> {

        CountDownLatch count;

        public InitTask(CountDownLatch count) {
            this.count = count;
        }

        @Override
        public Boolean call() throws Exception {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Destroy Task Call Back.
     */
    class DestroyTask implements Callable<Boolean> {

        CountDownLatch count;

        public DestroyTask(CountDownLatch count) {
            this.count = count;
        }

        @Override
        public Boolean call() throws Exception {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
