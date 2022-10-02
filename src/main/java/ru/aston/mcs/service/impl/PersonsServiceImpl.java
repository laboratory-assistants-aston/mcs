package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.PersonsDTO;
import ru.aston.mcs.mapper.PersonsMapper;
import ru.aston.mcs.repository.PersonsRepository;
import ru.aston.mcs.service.PersonsService;

import java.util.List;

@Service
@Transactional
public class PersonsServiceImpl implements PersonsService {

    private final PersonsRepository personsRepository;
    private final PersonsMapper personsMapper;

    public PersonsServiceImpl(PersonsRepository personsRepository, PersonsMapper personsMapper) {
        this.personsRepository = personsRepository;
        this.personsMapper = personsMapper;
    }

    @Override
    public List<PersonsDTO> getAllPersons() {
        return personsMapper.toDTOList(personsRepository.findAll());
    }

    @Override
    public PersonsDTO getPerson(Long personId) {
        return personsMapper.toDTO(
                personsRepository.findById(personId)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSavePerson(PersonsDTO personsDTO) {
        personsRepository.save(personsMapper.toModel(personsDTO));
    }

    @Override
    public void deletePerson(Long personId) {
        personsRepository.deleteById(personId);
    }
}
