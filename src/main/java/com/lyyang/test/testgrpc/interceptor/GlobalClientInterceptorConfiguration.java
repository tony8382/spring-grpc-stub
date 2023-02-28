package com.lyyang.test.testgrpc.interceptor;

import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalClientInterceptorConfiguration {

    @GrpcGlobalClientInterceptor
    LogGrpcInterceptor logClientInterceptor() {
        return new LogGrpcInterceptor();
    }

}