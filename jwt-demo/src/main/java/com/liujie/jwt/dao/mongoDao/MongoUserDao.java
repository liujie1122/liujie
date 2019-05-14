package com.liujie.jwt.dao.mongoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

}
