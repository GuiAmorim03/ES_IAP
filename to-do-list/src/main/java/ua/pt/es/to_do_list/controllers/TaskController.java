package ua.pt.es.to_do_list.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ua.pt.es.to_do_list.models.Task;
import ua.pt.es.to_do_list.services.TaskService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
@Tag(name = "Task", description = "The Task to be done")
public class TaskController {

    private TaskService taskService;
    
    @GetMapping("/{personId}")
    @Operation(summary = "Get list of tasks by person id", description = "Get list of tasks by person id")
    ResponseEntity<List<Task>> getTasksByPerson(Long personId) {
        return ResponseEntity.ok(taskService.getTasksByPersonId(personId));
    }

    @GetMapping("/{personId}/{taskId}")
    @Operation(summary = "Get a task by id and person id", description = "Get a task by id and person id")
    ResponseEntity<Task> getTaskByIdAndPerson(Long personId, Long taskId) {
        return ResponseEntity.ok(taskService.getTaskByIdAndPerson(taskId, personId));
    }
}
