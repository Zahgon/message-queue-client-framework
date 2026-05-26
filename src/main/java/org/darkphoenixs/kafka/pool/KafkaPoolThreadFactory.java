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

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: KafkaPoolThreadFactory</p>
 * <p>Description: Kafka池化线程工厂</p>
 *
 * @author Victor.Zxy
 * @version 1.2.0
 * @see ThreadFactory
 * @since 2016年4月28日
 */
public class KafkaPoolThreadFactory implements ThreadFactory {

    /**
     * 线程计数器
     */
    private AtomicInteger i = new AtomicInteger(0);

    /**
     * 线程前缀
     */
    private String prefix = "KafkaPool";

    /**
     * 线程优先级
     */
    private int priority;

    /**
     * 守护线程
     */
    private boolean daemon;

    /**
     * 默认构造方法
     */
    public KafkaPoolThreadFactory() {
    }

    /**
     * 构造方法初始化
     *
     * @param prefix 线程前缀
     */
    public KafkaPoolThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 构造方法初始化
     *
     * @param prefix 线程前缀
     * @param daemon 是否守护线程
     */
    public KafkaPoolThreadFactory(String prefix, boolean daemon) {
        this.prefix = prefix;
        this.daemon = daemon;
    }

    /**
     * 构造方法初始化
     *
     * @param priority 线程优先级
     * @param daemon   是否守护线程
     */
    public KafkaPoolThreadFactory(int priority, boolean daemon) {
        this.priority = priority;
        this.daemon = daemon;
    }

    /**
     * 构造方法初始化
     *
     * @param prefix   线程前缀
     * @param priority 线程优先级
     * @param daemon   是否守护线程
     */
    public KafkaPoolThreadFactory(String prefix, int priority, boolean daemon) {
        this.prefix = prefix;
        this.priority = priority;
        this.daemon = daemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the daemon
     */
    public boolean isDaemon() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param daemon the daemon to set
     */
    public void setDaemon(boolean daemon) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
