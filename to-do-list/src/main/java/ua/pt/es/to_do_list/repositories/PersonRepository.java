package ua.pt.es.to_do_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.pt.es.to_do_list.models.Person;

import java.util.UUID;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    
    public List<Person> findByName(String name);
    public Person findByEmail(String email);
    public Person findById(Long id);
    
}
