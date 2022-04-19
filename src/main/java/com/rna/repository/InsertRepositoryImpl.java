package com.rna.repository;

import com.rna.repository.interfaces.InsertRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * @Classname InsertRepositoryImpl
 * @Description mongodb文档插入实现类
 * @Date 2022/4/10 17:12
 * @Created by Sakura
 */
@Component
public class InsertRepositoryImpl implements InsertRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public boolean insert(List<Document> documents, String className) {
        System.out.println("inserting");
        System.out.println(documents.size());
        for (Document document : documents) {
            mongoTemplate.insert(document, className);
        }
        System.out.println("complete");
        return true;
    }
}
