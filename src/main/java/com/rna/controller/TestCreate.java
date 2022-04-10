package com.rna.controller;

import com.rna.service.CollectionRepositoryImpl;
import com.rna.springmvc.core.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestCreate
 * @Description 测试创建集合的接口
 * @Data 2022/4/10 16:31
 * @Created by Sakura
 */
@RequestMapping("/test")
@RestController
public class TestCreate {
    @Autowired
    private CollectionRepositoryImpl collectionRepository;
    @PostMapping("/create")
    public CommonResult create(String name){
        if (collectionRepository.createCollection(name)){
            return CommonResult.success("create successfully");
        }else {
            return CommonResult.error(400,"集合已存在");
        }
    }

}
