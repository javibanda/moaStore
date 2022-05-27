package moa.store.person.controller;

import moa.store.person.controller.service.PersonService;
import moa.store.person.model.entity.Person;
import moa.store.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> persons = personService.getAll();
        if(persons.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        Person personCreated = personService.create(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personCreated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id){
        Person personDeleted = personService.delete(id);
        if(null == personDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personDeleted);
    }
}
