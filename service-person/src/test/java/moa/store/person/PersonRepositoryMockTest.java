package moa.store.person;

import moa.store.person.model.entity.Person;
import moa.store.person.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class PersonRepositoryMockTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findPerson(){
        Person person1 = Person.builder()
                .name("Javi")
                .firstLastName("Polo")
                .secondLastName("Garro")
                .build();

        personRepository.save(person1);
    }
}
