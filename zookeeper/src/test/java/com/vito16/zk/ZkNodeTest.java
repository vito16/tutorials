/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * muyu@yiji.com 2016-03-04 17:34 创建
 */
package com.vito16.zk;

import com.google.common.collect.Lists;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/3/4
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class ZkNodeTest
{
    public static final String ZK_URL = "localhost:2181";

    @Test
    public void testCreateZNode(){
        try {
            ZooKeeper zk = new ZooKeeper(ZK_URL,60000,null);
            Stat stat = new Stat();
            ACL ac= new ACL();
            zk.create("/test/node-1",new String("abc").getBytes(), Lists.newArrayList(ac), CreateMode.PERSISTENT);
            List<ACL> aclList = zk.getACL("/test", stat);
            for(ACL acl:aclList){
                System.out.println(acl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
