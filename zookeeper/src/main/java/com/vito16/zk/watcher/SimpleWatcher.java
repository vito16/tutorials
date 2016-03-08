/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * muyu@yiji.com 2016-03-04 16:46 创建
 */
package com.vito16.zk.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/3/4
 */
public class SimpleWatcher implements Watcher {

    private static final Logger logger = LoggerFactory.getLogger(SimpleWatcher.class);

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("监控事件："+watchedEvent);
    }

}
