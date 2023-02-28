package com.lyyang.test.testgrpc.stub;

import com.lyyang.test.testgrpc.TestGrpcApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceTest extends TestGrpcApplicationTests {

    @Autowired
    private GreetingService greetingService;

    @Test
    void sayHello() {
        greetingService.sayHello("GG");
    }
}