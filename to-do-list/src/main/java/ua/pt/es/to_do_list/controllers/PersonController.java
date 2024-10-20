package ua.pt.es.to_do_list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get a person by id", description = "Get a person by id")
    ResponseEntity<String> getPersonById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(personService.getPersonById(id).getName());
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Get a list of people by name", description = "Get a list of people by name")
    ResponseEntity<List<String>> getPersonByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(personService.getPersonByName(name));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get a person by email", description = "Get a person by email")
    ResponseEntity<String> getPersonByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(personService.getPersonByEmail(email).getName());
    }
}
