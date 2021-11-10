package com.app.todo.helloworld;

import org.springframework.web.bind.annotation.*;

// Spring demo class
@RestController
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200", "https://cg1p-frontend.herokuapp.com"})
// Controller - Handle HTTP Requests
public class HelloWorldController {

    @GetMapping(path = "/hello-world/{userName}")
    public HelloWorldBean helloWorld(@PathVariable String userName) {
        return new HelloWorldBean(String.format("Hello World, %s", userName));
    }
}