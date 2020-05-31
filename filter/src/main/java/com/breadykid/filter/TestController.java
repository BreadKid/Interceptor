package com.breadykid.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试http接口
 * @author: Joyce Liu
 * @create: 2020-05-31 20:08
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String testApi(@RequestParam(value = "str") String param) {
        return param;
    }
}
