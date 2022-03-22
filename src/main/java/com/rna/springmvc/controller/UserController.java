package com.rna.springmvc.controller;

import com.rna.entity.UserVO;
import com.rna.springmvc.constants.ServiceExceptionEnum;
import com.rna.springmvc.core.exception.ServiceException;
import com.rna.springmvc.core.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获得指定用户编号的用户
     *
     * 提供不使用 CommonResult 包装
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new UserVO(id,UUID.randomUUID().toString());
    }

    /**
     * 获得指定用户编号的用户
     *
     * 提供使用 CommonResult 包装
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get2")
    public CommonResult<UserVO> get2(@RequestParam("id") Integer id) {
        // 查询用户
        UserVO user = new UserVO(id,UUID.randomUUID().toString());
        // 返回结果
        return CommonResult.success(user);
    }

    @GetMapping("/exception-01")
    public UserVO exception01(){
        throw new NullPointerException("空指针异常");
    }
    @GetMapping("/exception-02")
    public UserVO exception02(){
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @GetMapping("/do_something")
    public void doSomething(){
        logger.info("[doSomething]");
    }

    @GetMapping("/current_user")
    @ResponseBody
    public UserVO currentUser(){
        logger.info("[currentUser]");
        return new UserVO(10,UUID.randomUUID().toString());
    }

    @GetMapping("/exception-03")
    public void exception03() {
        logger.info("[exception03]");
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @PostMapping(value = "/add",
            // ↓ 增加 "application/xml"、"application/json" ，针对 Content-Type 请求头
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            // ↓ 增加 "application/xml"、"application/json" ，针对 Accept 请求头
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public UserVO add(@RequestBody UserVO user) {
        System.out.println("进入了此方法");
        return user;
    }
}