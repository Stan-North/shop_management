package com.javaacademy.shop_management.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    //2.1 Будет возвращать список наименований магазинов и их статус работы по запросу GET /shop/status.
    //2.1.2 Для получения статуса первого магазина сделает запрос GET http://localhost:8081/application/status
    //2.1.3 Для получения статуса второго магазина сделает запрос GET http://localhost:8082/application/status
}
