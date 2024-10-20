package ua.pt.es.to_do_list;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ua.pt.es.to_do_list.repositories.*;
import ua.pt.es.to_do_list.models.*;

@Component
public class InsertData implements CommandLineRunner {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;

    @Autowired
    public InsertData(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        personRepository.save(new Person("Guilherme", "guilhermeamorim@ua.pt", "guilherme"));
        
        taskRepository.save(new Task("Setup Frontend", "Create the frontend using React", Status.DONE, new Date(), "Frontend", Priority.MEDIUM, personRepository.findById(1L)));
        taskRepository.save(new Task("Set Up Backend", "Create the backend using Spring Boot", Status.IN_PROGRESS, new Date(), "Backend", Priority.HIGH, personRepository.findById(1L)));
        taskRepository.save(new Task("Set Up Database", "Initialize the PostgreSQL database and set up schemas.", Status.PENDING, new Date(), "Database", Priority.LOW, personRepository.findById(1L)));
        
    }
    
}
