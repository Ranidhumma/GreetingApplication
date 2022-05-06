package com.example.GreetingApplication.service;
import com.example.GreetingApplication.entity.Greeting;
import com.example.GreetingApplication.entity.User;
import com.example.GreetingApplication.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceimpl implements GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private GreetingRepository greetingRepository;

    /*
     * addGreeting Method
     */
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }
    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }
}

