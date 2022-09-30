package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.TypeResourcesDTO;
import ru.aston.mcs.service.TypeResourcesService;

import java.util.List;

@RestController
@RequestMapping("/api/type-resources")
public class TypeResourcesController {

    private final TypeResourcesService typeResourcesService;

    public TypeResourcesController(TypeResourcesService typeResourcesService) {
        this.typeResourcesService = typeResourcesService;
    }

    @GetMapping("/")
    public List<TypeResourcesDTO> getAllTypeResources() {

        return typeResourcesService.getAllTypeResources();

    }

    @GetMapping("/{id}")
    public TypeResourcesDTO getTypeResources(@PathVariable Long id) {
        return typeResourcesService.getTypeResources(id);
    }

    @PostMapping("/")
    public void addTypeResources(@RequestBody TypeResourcesDTO typeResourcesDto) {

        typeResourcesService.addAndSaveTypeResources(typeResourcesDto);
    }

    @PutMapping("/")
    public void updateTypeResources(@RequestBody TypeResourcesDTO typeResourcesDto) {

        typeResourcesService.addAndSaveTypeResources(typeResourcesDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeResources(@PathVariable Long id) {

        typeResourcesService.deleteTypeResources(id);
    }
}