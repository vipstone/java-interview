package com.interview.java.springbootlearning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.name}")
    private String appName;

    @RequestMapping("/index")
    public String index(String hiName) {
        return "Hello, " + hiName + " |@" + appName;
    }
}
