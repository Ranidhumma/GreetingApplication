package com.example.GreetingApplication.repository;
import com.example.GreetingApplication.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}


