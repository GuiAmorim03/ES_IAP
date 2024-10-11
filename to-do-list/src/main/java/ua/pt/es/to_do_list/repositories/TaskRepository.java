package ua.pt.es.to_do_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.pt.es.to_do_list.models.Task;
import ua.pt.es.to_do_list.models.Person;

import java.util.UUID;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    public Task findByIdAndPerson(Long id, Person person);
    public List<Task> findByPerson(Person person);
  
}