package com.serviceB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VerifyApiImpl implements VerifyApi {
    private final RestTemplate restTemplate;

    @Value("${serviceA.url}")
    private String serviceAUrl;

    @Autowired
    public VerifyApiImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public NameVerified verifyName(String name) {
        NameVerified nameVerified = this.restTemplate.postForObject(serviceAUrl + "/api/verify?name=" + name, null, NameVerified.class);

        return nameVerified;
    }
}
