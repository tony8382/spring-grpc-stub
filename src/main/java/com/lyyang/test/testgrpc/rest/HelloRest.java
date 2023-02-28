package com.lyyang.test.testgrpc.rest;

import com.lyyang.test.testgrpc.model.Hello;
import com.lyyang.test.testgrpc.stub.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloRest {

    private GreetingService greetingService;

    public HelloRest(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        return greetingService.sayHello(name);
    }
}
