package com.rna.repository.interfaces;

import org.bson.Document;

import java.util.List;

/**
 * @Classname InsertRepository
 * @Description mongodb文档插入接口类
 * @Date 2022/4/10 17:12
 * @Created by Sakura
 */


public interface InsertRepository {
    boolean insert(List<Document> documents, String className);
}
