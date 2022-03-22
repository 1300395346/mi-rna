package com.rna.controller;

import com.rna.entity.SRPPaper;
import com.rna.repository.SRPPaperRepository;
import com.rna.springmvc.core.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname TestHandler
 * @Description 测试接口
 * @Date 2022/3/22 16:17
 * @Created by TaoVh
 */
@RequestMapping("/test")
@RestController
public class TestHandler {
    @Autowired
    private SRPPaperRepository srpPaperRepository;
    @PostMapping("/save")
    public CommonResult save(SRPPaper srpPaper){
        if(srpPaperRepository.save(srpPaper)){
            return CommonResult.success("保存成功");
        }else {
            return CommonResult.error(400,"未知错误");
        }
    }
}
