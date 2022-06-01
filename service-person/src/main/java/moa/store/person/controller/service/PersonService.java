package moa.store.person.controller.service;

import moa.store.person.model.entity.Person;
import moa.store.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person>{


    @Autowired
    public PersonService(PersonRepository personRepository){
        repository = personRepository;
    }






}
