package com.javaacademy.shop_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "модель магазина")
public class ShopDto {
    @JsonProperty("name")
    @Schema(description = "название магазина")
    private String name;

    @JsonProperty("shopStatus")
    @Schema(description = "статус магазина - открыт или закрыт в данное время")
    private String shopStatus;

    @JsonProperty("time_open")
    @Schema(description = "время открытия магазина")
    private String timeOpen;

    @JsonProperty("time_close")
    @Schema(description = "время закрытия магазина")
    private String timeClose;

}
