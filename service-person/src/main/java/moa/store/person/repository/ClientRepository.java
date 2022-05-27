package moa.store.person.repository;

import moa.store.person.model.entity.Client;
import moa.store.person.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findByPerson(Person person);
}
