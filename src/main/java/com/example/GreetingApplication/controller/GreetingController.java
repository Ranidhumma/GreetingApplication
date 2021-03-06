package com.example.GreetingApplication.controller;

import com.example.GreetingApplication.entity.Greeting;
import com.example.GreetingApplication.entity.User;
import com.example.GreetingApplication.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /*UC5
     *Ability for the Greeting App to find a Greeting Message by Id in the Repository.
     *localhost:8080/path/5
     *"id": 5,
     *"message": "Hello, Rani!"
     */
    @GetMapping("/path/{id}")
    public Greeting getElementById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    /* UC6:
     * Ability for the Greeting App to List all the Greeting Messages in the Repository
     * localhost:8080/all
     */
    @GetMapping("/all")
    public List<Greeting> getAll() {
        return greetingService.getAll();

    }

    /*UC7
     *Ability for the Greeting App to Delete a Greeting Messages in the Repository
     *localhost:8080/delete/3
     */
    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id) {
        return greetingService.deleteGreetingById(id);
    }

    /*UC8
     *Ability for the Greeting App to Edit a Greeting Messages in the Repository
     * edit the greeting message
     */

    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name) {
        return greetingService.editGreetingById(id, name);
    }
}



