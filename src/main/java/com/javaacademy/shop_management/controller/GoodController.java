package com.javaacademy.shop_management.controller;

import com.javaacademy.shop_management.dto.UpdateGoodPriceDto;
import com.javaacademy.shop_management.service.GoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Goods controller", description = "Контроллер для работы с товарами")
public class GoodController {
    private static final String URL_FIRST = "http://localhost:8081/shop/good";
    private static final String URL_SECOND = "http://localhost:8082/shop/good";
    private final GoodService goodService;

    @PatchMapping("shop/good")
    @Operation(summary = "Замена цены на товар в магазинах",
            description = "Получает json с названием товара и новой ценой, заменяет цену этого товара в магазинах")
    @ApiResponse(responseCode = "200", description = "Успешное обновление стоимости")
    @RequestBody(
            description = "данные для смены стоимости",
            content = @Content(
                    schema = @Schema(implementation = UpdateGoodPriceDto.class)))
    public void updatePrice(
            @org.springframework.web.bind.annotation.RequestBody UpdateGoodPriceDto dto) throws IOException {
        goodService.requestToUpdatePrice(URL_FIRST, dto);
        goodService.requestToUpdatePrice(URL_SECOND, dto);
    }


}
