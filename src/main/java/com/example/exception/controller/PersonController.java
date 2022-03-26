package com.example.exception.controller;

import com.example.exception.entity.Person;
import com.example.exception.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping
    public List<Person> listAllPersons() {
        return service.listAllPersons();
    }

    @GetMapping("/get-person")
    public Person getPersonById(@RequestParam(value = "id") Long id){
        return service.getPersonById(id);
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return service.savePerson(person);
    }
}
