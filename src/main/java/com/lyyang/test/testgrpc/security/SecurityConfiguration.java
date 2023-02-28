package com.lyyang.test.testgrpc.security;


import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.StubTransformer;
import net.devh.boot.grpc.client.security.CallCredentialsHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration(proxyBeanMethods = false)
public class SecurityConfiguration {

    @Value("${auth.token}")
    private String token;

    @Bean
    public StubTransformer call() {
        return (name, stub) -> {
            if ("local-grpc-server".equals(name)) {
                return stub.withCallCredentials(CallCredentialsHelper.authorizationHeader(token));
            }
            return stub;
        };
    }

}