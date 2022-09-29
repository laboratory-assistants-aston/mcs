package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dao.TypeResourcesService;
import ru.aston.mcs.entity.TypeResources;

import java.util.List;

@RestController
@RequestMapping("/api/v1/type-resources")
public class TypeResourcesController {

    private final TypeResourcesService typeResourcesService;

    public TypeResourcesController(TypeResourcesService typeResourcesService) {
        this.typeResourcesService = typeResourcesService;
    }

    @GetMapping("/")
    public List<TypeResources> getAllTypeResources() {

        return typeResourcesService.getAllTypeResources();
    }

    @GetMapping("/{id}")
    public TypeResources getTypeResources(@PathVariable int id) {

        return typeResourcesService.getTypeResources(id);
    }

    @PostMapping("/")
    public TypeResources addTypeResources(@RequestBody TypeResources typeResources) {

        typeResourcesService.saveTypeResources(typeResources);

        return typeResources;
    }

    @PutMapping("/")
    public TypeResources updateTypeResources(@RequestBody TypeResources typeResources) {

        typeResourcesService.saveTypeResources(typeResources);

        return typeResources;
    }

    @DeleteMapping("/{id}")
    public String deleteTypeResources(@PathVariable int id) {

        typeResourcesService.deleteTypeResources(id);

        return "TypeResources " + id + "was deleted";
    }
}