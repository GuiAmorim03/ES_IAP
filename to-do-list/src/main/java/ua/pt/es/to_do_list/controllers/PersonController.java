package ua.pt.es.to_do_list.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ua.pt.es.to_do_list.services.PersonService;

@CrossOrigin
@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "The Person who uses the application")
public class PersonController {
    
    private PersonService personService;

    @GetMapping("/id")
    @Operation(summary = "Get a person by id", description = "Get a person by id")
    ResponseEntity<String> getPersonById(Long id) {
        return ResponseEntity.ok().body(personService.getPersonById(id).getName());
    }

    @GetMapping("/name")
    @Operation(summary = "Get a list of people by name", description = "Get a list of people by name")
    ResponseEntity<List<String>> getPersonByName(String name) {
        return ResponseEntity.ok().body(personService.getPersonByName(name));
    }

    @GetMapping("/email")
    @Operation(summary = "Get a person by email", description = "Get a person by email")
    ResponseEntity<String> getPersonByEmail(String email) {
        return ResponseEntity.ok().body(personService.getPersonByEmail(email).getName());
    }
}
