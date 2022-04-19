package com.rna.controller;

import com.rna.repository.InsertRepositoryImpl;
import com.rna.repository.readCSVRepositoryImpl;
import com.rna.springmvc.core.vo.CommonResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname TestRead
 * @Description 测试读取并存入的接口
 * @Data 2022/4/10 16:31
 * @Created by Sakura
 */
@RequestMapping("/test")
@RestController
public class TestRead {
    @Autowired
    private InsertRepositoryImpl insert;

    @Autowired
    private readCSVRepositoryImpl read;

    @PostMapping("/readAndInsert")
    public CommonResult readAndInsert(String URL, String name, @RequestParam(required = false) Object[] index){
        List<Stream<String>> data = read.readCSV(URL,name);
        List<Document> realData = read.analysis(data,index);
        if (insert.insert(realData,name)){
            return CommonResult.success("插入成功");
        } else {
            return CommonResult.error(400,"未知错误");
        }
    }
}
