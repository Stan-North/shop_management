package com.javaacademy.shop_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_management.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public ShopDto makeRequest(String url) throws IOException {
        Request request = new Request.Builder().get().url(url).build();
        String responseBody = client.newCall(request).execute().body().string();
        return mapper.readValue(responseBody, ShopDto.class);
    }
}
