package ua.pt.es.to_do_list.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ua.pt.es.to_do_list.dto.TaskToEdit;
import ua.pt.es.to_do_list.models.Person;
import ua.pt.es.to_do_list.models.Task;
import ua.pt.es.to_do_list.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskService(TaskRepository taskRepository, PersonService personService) {
        this.taskRepository = taskRepository;
        this.personService = personService;
    }

    private PersonService personService;
    
    private TaskRepository taskRepository;

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public List<Task> getTasksByPersonId(Long personId) {
        Person person = personService.getPersonById(personId);
        return taskRepository.findByPerson(person);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void updateTask(TaskToEdit taskToEdit) {
        Task task = getTaskById(taskToEdit.getId());
        task.setTitle(taskToEdit.getTitle());
        task.setDescription(taskToEdit.getDescription());
        task.setDeadline(taskToEdit.getDeadline());
        task.setCategory(taskToEdit.getCategory());
        task.setPriority(taskToEdit.getPriority());
        task.setStatus(taskToEdit.getStatus());

        taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
    
}
