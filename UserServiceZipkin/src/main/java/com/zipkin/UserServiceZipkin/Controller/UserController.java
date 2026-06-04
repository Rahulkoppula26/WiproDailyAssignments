package com.zipkin.UserServiceZipkin.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {

        logger.info("******************Inside User Service**************************");

        String response = restTemplate.getForObject(
                "http://localhost:8080/product/" + id,
                String.class);

        return "User Purchased -> " + response;
    }
}
