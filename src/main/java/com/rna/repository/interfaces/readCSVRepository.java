package com.rna.repository.interfaces;


import org.bson.Document;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname readCSVRepository
 * @Description 读取并分析csv文件接口类
 * @Data 2022/4/12 21:27
 * @Created by Sakura
 */
public interface readCSVRepository {
    List<Stream<String>> readCSV(String URL, String collectionName);
    List<Document> analysis(List<Stream<String>> data, Object[] index);
}
