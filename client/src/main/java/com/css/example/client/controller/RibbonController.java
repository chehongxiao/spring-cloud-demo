package com.css.example.client.controller;

import com.css.example.client.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    private static final String REST_URL_PREFIX = "http://CLOUD-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "serviceFailture")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/"+id,User.class);
    }

    public User serviceFailture(Long id){
        User user = new User();
        user.setId(-1L);
        user.setUsername("断路器");
        user.setAge(0);
        user.setBalance((double) 0);
        return user;
    }
}
