package com.javaacademy.shop_management.controller;

import com.javaacademy.shop_management.dto.ShopDto;
import com.javaacademy.shop_management.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Shop controller", description = "Контроллер для работы с магазинами")
public class ShopController {
    private static final String URL_FIRST = "http://localhost:8081/application/status";
    private static final String URL_SECOND = "http://localhost:8082/application/status";
    private final ShopService shopService;

    @GetMapping("/shop/status")
    @Operation(summary = "Получение статусов магазинов", description = "Получает статусы обоих магазинов")
    @ApiResponse(
            responseCode = "200",
            description = "успешный возврат статусов",
            content = {
                    @Content(mediaType = "application.json",
                            array = @ArraySchema(schema = @Schema(implementation = ShopDto.class)))
            })
    public List<ShopDto> getShopStatuses() throws IOException {
        List<ShopDto> list = new ArrayList<>();
        list.add(shopService.makeRequest(URL_FIRST));
        list.add(shopService.makeRequest(URL_SECOND));
        return list;
    }
}
