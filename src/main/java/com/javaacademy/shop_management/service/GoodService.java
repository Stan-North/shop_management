package com.javaacademy.shop_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_management.confilg.HttpClient;
import com.javaacademy.shop_management.dto.UpdateGoodPriceDto;
import lombok.RequiredArgsConstructor;
import okhttp3.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GoodService {
    private final HttpClient client;

    public void requestToUpdatePrice(String url, UpdateGoodPriceDto dto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] body = mapper.writeValueAsBytes(dto);
        Request request = new Request.Builder().patch(okhttp3.RequestBody.create(body))
                .url(url)
                .addHeader("Content-type", "application/json")
                .build();
        client.getClient().newCall(request).execute().body().string();
    }
}
