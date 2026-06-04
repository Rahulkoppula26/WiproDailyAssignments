package com.wipro.ProductService.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdCont {

    @Value("${server.port}") //8082
    private String port;

    @GetMapping("/product")
    public String getProduct() {
        return "Product Service Response from Port : " + port;
    }
}