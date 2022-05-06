package com.example.GreetingApplication.controller;

import com.example.GreetingApplication.entity.Greeting;
import com.example.GreetingApplication.entity.User;
import com.example.GreetingApplication.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;
    private static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();//used for auto increment

    /* UC1-UC4
     * Ability for the Greeting App to give Greeting message HelloWorld
     * localhost:8080/greeting
     * @return message: "message": "Hello, world!"
     * Ability for the Greeting App to give Greeting message with firstname and lastname
     * localhost:8080/greeting?name=Rani&name=Dhumma
     * message": "Hello, Rani,Dhumma!"
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {

        User user = new User();
        user.setFirstName(name);
        System.out.println(user);
        return greetingService.addGreeting(user);

    }


}

