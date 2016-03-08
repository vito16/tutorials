/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * muyu@yiji.com 2016-03-04 14:54 创建
 */
package com.vito16.mongo;

import com.google.common.collect.Lists;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.mongodb.client.model.Filters.eq;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * MongoDB测试
 *
 * @author 木鱼 muyu@yiji.com
 * @version 2016/3/4
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MongoDBTest {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBTest.class);

    MongoDatabase db;

    @Before
    public void getDb(){
        MongoClient mongoClient = new MongoClient();
        db = mongoClient.getDatabase("test");
    }

    @Test
    public void testGetConn(){
        logger.info(db.toString());
        assertThat(db).isNotNull();
    }

    @Test
    public void testInsert(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        try {
            db.getCollection("test").insertOne(
                    new Document("address",
                            new Document()
                                    .append("street", "muxing1qu")
                                    .append("zipcode", "123456")
                                    .append("building", "1234")
                                    .append("coord", Lists.newArrayList(-73.9557413, 40.7720266)))
                            .append("borough", "Manhattan")
                            .append("cuisine", "China")
                            .append("grades", Lists.newArrayList(
                                    new Document()
                                            .append("date", format.parse("2014-10-01T00:00:00Z"))
                                            .append("grade", "A")
                                            .append("score", 11),
                                    new Document()
                                            .append("date", format.parse("2014-01-16T00:00:00Z"))
                                            .append("grade", "B")
                                            .append("score", 17)))
                            .append("name", "Vito")
                            .append("restaurant_id", "41704620"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery(){
        FindIterable<Document> iterable = db.getCollection("test").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                logger.info(document.toString());
            }
        });
    }

    @Test
    public void testQueryEq(){
        FindIterable<Document> iterable = db.getCollection("test").find(eq("name","Vito"));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                logger.info(document.toString());
            }
        });
    }

    @Test
    public void testUpdate(){
        testQueryEq();
        db.getCollection("test").updateOne(new Document("name", "Vito"),
                new Document("$set", new Document("cuisine", "Canada"))
                        .append("$currentDate", new Document("lastModified", true)));
        testQueryEq();
    }

    @Test
    public void testRemove(){
        db.getCollection("test").deleteOne(eq("name","Vito"));
        testQuery();
    }
}
