package com.rna.repository;

import com.rna.repository.interfaces.readCSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Component;
import org.bson.Document;
import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname readCSVRepositoryImpl
 * @Description 读取并分析CSV文件的实现类
 * @Data 2022/4/12 21:31
 * @Created by Sakura
 */
@Component
public class readCSVRepositoryImpl implements readCSVRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    InsertRepositoryImpl insertRepository;

    final String charset = "utf-8";

    @Override
    public List<Stream<String>> readCSV(String URL,String collectionName) {
        boolean exist = mongoTemplate.collectionExists(collectionName);
        if (!exist){
            mongoTemplate.createCollection(collectionName);
        }
        List<Stream<String>> data = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(new FileInputStream(URL), charset))).build()) {
            for (String[] strings : csvReader) {
                data.add(Arrays.stream(strings));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("文件读取成功");
        return data;
    }

    @Override
    public List<Document> analysis(List<Stream<String>> data, Object[] index) {
        Object[] title = data.get(0).toArray();
        System.out.println(Arrays.toString(index));
        if (!ArrayUtils.isEmpty(index)){
            title = index;
        }
        List<Document> documents = new ArrayList<>();
        for (int i = 1; i < data.size();++i){
            Object[] value = data.get(i).toArray();
            Document document = new Document();
            for (int j = 0; j < title.length; ++j) {
                document.append((String) title[j], value[j]);
            }
            documents.add(document);
        }
        System.out.println("分析成功");
        return documents;
    }
}
