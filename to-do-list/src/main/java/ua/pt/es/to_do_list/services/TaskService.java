package ua.pt.es.to_do_list.services;

import org.springframework.stereotype.Service;

import ua.pt.es.to_do_list.models.Person;
import ua.pt.es.to_do_list.models.Task;
import ua.pt.es.to_do_list.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private PersonService personService;
    
    private TaskRepository taskRepository;

    public Task getTaskByIdAndPerson(Long id, Long personId) {
        Person person = personService.getPersonById(personId);
        return taskRepository.findByIdAndPerson(id, person);
    }

    public List<Task> getTasksByPersonId(Long personId) {
        Person person = personService.getPersonById(personId);
        return taskRepository.findByPerson(person);
    }
    
}
