package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private static final String template = "Welcome, %s!";
    private final AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/welcome")
    public WelcomeMessage welcome(@RequestParam(value = "name", defaultValue = "Guest") String name) {        
        return new WelcomeMessage(atomicLong.incrementAndGet(), String.format(template, name));     
    }
}