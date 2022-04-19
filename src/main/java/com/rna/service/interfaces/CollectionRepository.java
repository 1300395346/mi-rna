package com.rna.service.interfaces;

/**
 * @Classname CollectionRepository
 * @Description mongodb集合操作接口类
 * @Date 2022/4/10 16:31
 * @Created by Sakura
 */

public interface CollectionRepository {
    boolean createCollection(String collectionName);
    void dropCollection(String collectionName);
}
