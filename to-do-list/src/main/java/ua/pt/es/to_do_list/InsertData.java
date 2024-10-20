package ua.pt.es.to_do_list;

import java.time.LocalDateTime;

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

    // @SuppressWarnings("deprecation")
    @Override
    public void run(String... args) throws Exception {

        personRepository.save(new Person("Guilherme", "guilhermeamorim@ua.pt", "guilherme"));
        
        Task task1 = new Task("Setup Frontend", "Create the frontend using React", LocalDateTime.of(2024, 10, 20, 23, 59), "Frontend", Priority.MEDIUM, personRepository.findById(1L));
        Task task2 = new Task("Set Up Backend", "Create the backend using Spring Boot", LocalDateTime.of(2024, 10, 20, 23, 59), "Backend", Priority.HIGH, personRepository.findById(1L));
        task2.setStatus(Status.IN_PROGRESS);
        Task task3 = new Task("Set Up Database", "Initialize the PostgreSQL database and set up schemas.", LocalDateTime.of(2024, 10, 20, 23, 59), "Database", Priority.LOW, personRepository.findById(1L));
        task3.setStatus(Status.DONE);

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
    }
    
}
