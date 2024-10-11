package ua.pt.es.to_do_list.services;

import org.springframework.stereotype.Service;

import ua.pt.es.to_do_list.models.Person;
import ua.pt.es.to_do_list.repositories.PersonRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class PersonService {

    private PersonRepository personRepository;

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
    
}
