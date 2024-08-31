package com.lyyang.test.testgrpc.stub;

import com.lyyang.test.testgrpc.TestGrpcApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
class GreetingServiceTest extends TestGrpcApplicationTests {

    @Autowired
    private GreetingService greetingService;

    @Test
    void sayHello() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);  // Create a pool of 3 threads

        // List to hold Future objects
        List<Future<String>> futures = new ArrayList<>();

        // Define the task
        Callable<String> task = () -> {
            try {
                String response = greetingService.sayHello("GG");
                log.info("R:{}", response);
                return response;
            } catch (Exception e) {
                log.warn("EX:{}", e);
                throw e;  // Rethrow if you need to handle it further up the call stack
            }
        };

        try {
            // Submit 30 tasks to the executor
            for (int i = 0; i < 30; i++) {
                Future<String> future = executorService.submit(task);
                futures.add(future);
            }

            // Optionally, process the results
            for (Future<String> future : futures) {
                try {
                    String result = future.get(); // Blocking call to get the result
                    log.info("Result: {}", result);
                } catch (Exception e) {
                    log.error("Error getting result from task", e);
                }
            }
        } finally {
            // Shutdown the executor
            executorService.shutdown();
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