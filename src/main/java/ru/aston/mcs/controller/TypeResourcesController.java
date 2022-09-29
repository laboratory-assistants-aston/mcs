package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dao.TypeResourcesService;
import ru.aston.mcs.dto.TypeResourcesDTO;
import ru.aston.mcs.entity.TypeResources;
import ru.aston.mcs.mappers.TypeResourcesListMapper;
import ru.aston.mcs.mappers.TypeResourcesMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/type-resources")
public class TypeResourcesController {

    public final TypeResourcesListMapper typeResourcesListMapper;
    public final TypeResourcesMapper typeResourcesMapper;
    private final TypeResourcesService typeResourcesService;

    public TypeResourcesController(TypeResourcesListMapper typeResourcesListMapper, TypeResourcesMapper typeResourcesMapper, TypeResourcesService typeResourcesService) {
        this.typeResourcesListMapper = typeResourcesListMapper;
        this.typeResourcesMapper = typeResourcesMapper;
        this.typeResourcesService = typeResourcesService;
    }

    @GetMapping("/")
    public List<TypeResourcesDTO> getAllTypeResources(){

        List<TypeResources> allTypeResources = typeResourcesService.getAllTypeResources();

        return  typeResourcesListMapper.toDTOList(allTypeResources);

    }

    @GetMapping("/{id}")
    public TypeResourcesDTO getTypeResources(@PathVariable int id){

        TypeResources typeResources = typeResourcesService.getTypeResources(id);

        return  typeResourcesMapper.toDTO(typeResources);
    }

    @PostMapping("/")
    public TypeResourcesDTO addTypeResources(@RequestBody TypeResourcesDTO typeResourcesDto){

        TypeResources typeResources = typeResourcesMapper.toModel(typeResourcesDto);
        typeResourcesService.saveTypeResources(typeResources);

        return typeResourcesDto;
    }

    @PutMapping("/")
    public TypeResourcesDTO updateTypeResources(@RequestBody TypeResourcesDTO typeResourcesDto){

        TypeResources typeResources = typeResourcesMapper.toModel(typeResourcesDto);
        typeResourcesService.saveTypeResources(typeResources);

        return typeResourcesDto;
    }

    @DeleteMapping("/{id}")
    public String deleteTypeResources(@PathVariable int id){

        typeResourcesService.deleteTypeResources(id);

        return "TypeResources " + id + "was deleted";
    }
}