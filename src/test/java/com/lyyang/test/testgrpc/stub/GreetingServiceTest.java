package com.lyyang.test.testgrpc.stub;

import com.lyyang.test.testgrpc.TestGrpcApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class GreetingServiceTest extends TestGrpcApplicationTests {

    @Autowired
    private GreetingService greetingService;

    @Test
    void sayHello() {

        try {
            log.info("R:{}", greetingService.sayHello("GG"));
        } catch (Exception e) {
            log.warn("EX:{}", e);
        }

        try {
            log.info("R:{}", greetingService.sayHelloAdmin("GGTT"));
        } catch (Exception e) {
            log.warn("EX:{}", e);
        }

    }

    @Test
    void auth() {
        log.info("GGG:{}", greetingService.auth("user", "123456"));
    }
}