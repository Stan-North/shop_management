package com.javaacademy.shop_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_management.dto.UpdateGoodPriceDto;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GoodService {
    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public void requestToUpdatePrice(String url, UpdateGoodPriceDto dto) throws IOException {
        byte[] body = mapper.writeValueAsBytes(dto);
        Request request = new Request.Builder()
                .patch(okhttp3.RequestBody.create(body))
                .url(url)
                .addHeader("Content-type", "application/json")
                .build();
        client.newCall(request).execute().body().string();
    }
}
