package com.css.example.provider.controller;

import com.css.example.provider.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        System.out.println("port:"+port);
        User findOne = new User();
        if (id == 1) {
            findOne.setAge(20);
            findOne.setName("zhangsan");
            findOne.setUsername("zhangsan");
            findOne.setId(1L);
            findOne.setBalance(800D);
        } else if(id == 3){
            findOne.setAge(20);
            findOne.setName("zhangsan");
            findOne.setUsername("zhangsan");
            findOne.setId(10L);
            findOne.setBalance(800D);
            int i = 1 / 0;
        } else {
            findOne.setAge(18);
            findOne.setName("lisi");
            findOne.setUsername("lisi");
            findOne.setId(2L);
            findOne.setBalance(2000D);
        }
        return findOne;
    }
}

