package ua.pt.es.to_do_list.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.pt.es.to_do_list.dto.PersonToCreate;
import ua.pt.es.to_do_list.models.Person;
import ua.pt.es.to_do_list.repositories.PersonRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<String> getPersonByName(String name) {
        List<Person> people = personRepository.findByName(name);
        List<String> names = new ArrayList<>();
        for (Person person : people) {
            names.add(person.getName());
        }
        return names;
    }

    public Person getPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person addPerson(PersonToCreate personToCreate) {
        System.out.println("PersonService.addPerson");
        System.out.println(personToCreate);
        System.out.println(personToCreate.getName());
        System.out.println(personToCreate.getEmail());
        Person existingPerson = personRepository.findByEmail(personToCreate.getEmail());
        if (existingPerson != null) {
            return existingPerson;
        }
        Person newPerson = new Person(personToCreate.getName(), personToCreate.getEmail());
        return personRepository.save(newPerson);
    }

}
