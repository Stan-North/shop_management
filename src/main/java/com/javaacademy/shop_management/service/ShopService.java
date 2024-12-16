package com.javaacademy.shop_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_management.util.HttpClient;
import com.javaacademy.shop_management.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import okhttp3.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final HttpClient client;

    public ShopDto makeRequest(String url) throws IOException {
        Request request = new Request.Builder().get().url(url).build();
        String responseBody = client.getClient().newCall(request).execute().body().string();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, ShopDto.class);
    }
}
