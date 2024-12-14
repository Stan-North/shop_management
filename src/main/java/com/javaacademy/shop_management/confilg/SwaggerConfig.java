package com.javaacademy.shop_management.confilg;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        Info info = new Info()
                .title("Api для управления магазинами")
                .description("публичное апи магазинов семерочка и девяточка");
        return new OpenAPI().info(info);
    }
}
