package ua.pt.es.to_do_list.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ua.pt.es.to_do_list.dto.TaskToCreate;
import ua.pt.es.to_do_list.models.Person;
import ua.pt.es.to_do_list.models.Task;
import ua.pt.es.to_do_list.services.PersonService;
import ua.pt.es.to_do_list.services.TaskService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
@Tag(name = "Task", description = "The Task to be done")
public class TaskController {

    private TaskService taskService;
    private PersonService personService;

    @Autowired
    public TaskController(TaskService taskService, PersonService personService) {
        this.taskService = taskService;
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    @Operation(summary = "Get list of tasks by person id", description = "Get list of tasks by person id")
    ResponseEntity<List<Task>> getTasksByPerson(@PathVariable("personId") Long personId) {
        return ResponseEntity.ok(taskService.getTasksByPersonId(personId));
    }

    @GetMapping("/{personId}/{taskId}")
    @Operation(summary = "Get a task by id and person id", description = "Get a task by id and person id")
    ResponseEntity<Task> getTaskByIdAndPerson(@PathVariable("personId") Long personId, Long taskId) {
        return ResponseEntity.ok(taskService.getTaskByIdAndPerson(taskId, personId));
    }

    @PostMapping("")
    @Operation(summary = "Create a new task", description = "Create a new task")
    public ResponseEntity<Task> createTask(@RequestBody TaskToCreate taskToCreate) {
        Person person = personService.getPersonById(taskToCreate.getPersonId());
        Task task = new Task(taskToCreate.getTitle(), taskToCreate.getDescription(), taskToCreate.getDeadline(), taskToCreate.getCategory(), taskToCreate.getPriority(), person);

        return ResponseEntity.ok(taskService.createTask(task));
    }

}
