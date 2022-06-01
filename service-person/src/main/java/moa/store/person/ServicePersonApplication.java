package moa.store.person;

import moa.store.person.model.entity.Person;
import moa.store.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicePersonApplication {


	public static void main(String[] args) {
		printPerson();
		SpringApplication.run(ServicePersonApplication.class, args);
	}


	public static void printPerson(){
		Person person = Person.builder().id(4L).name("asd").build();
		System.out.println(person);


	}

}
