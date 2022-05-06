package com.example.GreetingApplication.service;

import com.example.GreetingApplication.entity.Greeting;
import com.example.GreetingApplication.entity.User;

import java.util.List;

public interface GreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    List<Greeting> getAll();

    List<Greeting> deleteGreetingById(Long id);
}



