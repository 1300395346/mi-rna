package com.rna.service;

import com.rna.service.interfaces.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CollectionRepositoryImpl implements CollectionRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean createCollection(String collectionName) {
        boolean exists = mongoTemplate.collectionExists(collectionName);
        if (!exists){
            mongoTemplate.createCollection(collectionName);
            return true;
        }
        return false;
    }

    @Override
    public void dropCollection(String collectionName) {
        mongoTemplate.dropCollection(collectionName);
    }
}
