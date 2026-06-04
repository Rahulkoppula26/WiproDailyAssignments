package com.wipro.UserService.MyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;    


@Configuration
public class SwaggerConfig{

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("UserService")
                .version("1.0")
                .description("Spring Boot User Api Testing"));
    }
}
