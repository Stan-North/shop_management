package com.javaacademy.shop_management.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class HttpClient {
    private final OkHttpClient client;

}
