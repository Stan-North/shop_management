package com.javaacademy.shop_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Schema(description = "данные для смены цены у товара")
public class UpdateGoodPriceDto {
    @JsonProperty("name")
    @Schema(description = "название товара")
    private String name;

    @JsonProperty("new_price")
    @Schema(description = "новая цена товара")
    private BigDecimal price;
}
