package moa.store.person.controller.service;

import moa.store.person.model.entity.Client;
import moa.store.person.model.entity.Person;
import moa.store.person.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends BaseService<Client>{


    PersonService personService;
    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository, PersonService personService){
        repository = clientRepository;
        this.personService = personService;
        this.clientRepository =  clientRepository;
    }

    public boolean hashPerson(Long idPerson){
        Person person = personService.getOne(idPerson);
        if(person == null) return false;
        return clientRepository.findByPerson(person) != null ;
    }
}
