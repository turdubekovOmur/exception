package com.example.exception.service;

import com.example.exception.entity.Person;
import com.example.exception.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<Person> listAllPersons() {
        return repository.findAll();
    }

    public Person getPersonById(Long id){
       return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    public Person savePerson(Person person){
        return repository.save(person);
    }
}
