package com.javaacademy.shop_management.confilg;

import lombok.Getter;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;

@Component
@Getter
public class HttpClient {
    private final OkHttpClient client = new OkHttpClient();

}
