package ru.aston.mcs.service;

import ru.aston.mcs.dto.PersonsDTO;

import java.util.List;

public interface PersonsService {
    List<PersonsDTO> getAllPersons();

    PersonsDTO getPerson(Long personId);

    void addAndSavePerson(PersonsDTO personsDTO);

    void deletePerson(Long personId);
}
