package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.PersonsDTO;
import ru.aston.mcs.service.PersonsService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonsController {

    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/")
    public List<PersonsDTO> getAllPersons() {
        return personsService.getAllPersons();
    }

    @GetMapping("/{id}")
    public PersonsDTO getPerson(@PathVariable Long id) {
        return personsService.getPerson(id);
    }

    @PostMapping("/")
    public void addPerson(@RequestBody PersonsDTO personsDto) {
        personsService.addAndSavePerson(personsDto);
    }

    @PutMapping("/")
    public void updatePerson(@RequestBody PersonsDTO personsDto) {
        personsService.addAndSavePerson(personsDto);
    }
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        personsService.deletePerson(id);
    }
}
