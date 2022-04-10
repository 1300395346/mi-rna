package com.rna.service.interfaces;

public interface CollectionRepository {
    boolean createCollection(String collectionName);
    void dropCollection(String collectionName);
}
