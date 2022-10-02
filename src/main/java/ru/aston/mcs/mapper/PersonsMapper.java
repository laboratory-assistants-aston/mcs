package ru.aston.mcs.mapper;

import ru.aston.mcs.dto.PersonsDTO;
import ru.aston.mcs.entity.Person;

import java.util.List;

public interface PersonsMapper {
    Person toModel(PersonsDTO personsDto);

    PersonsDTO toDTO(Person person);

    List<Person> toModelList(List<PersonsDTO> personsDTOList);

    List<PersonsDTO> toDTOList(List<Person> personDTOList);
}
