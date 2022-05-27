package moa.store.person.controller;


import moa.store.person.controller.service.ClientService;

import moa.store.person.controller.service.PersonService;
import moa.store.person.model.entity.Client;
import moa.store.person.model.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.getAll();
        if(clients.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client,
                                               @RequestParam(name = "idPerson") Long idPerson,
                                               BindingResult result){
        Person person = personService.getOne(idPerson);
        if(result.hasErrors() || person==null || clientService.hashPerson(idPerson)){
            return ResponseEntity.badRequest().build();
        }
        client.setPerson(person);
        Client clientCreated = clientService.create(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientCreated);
    }
}
