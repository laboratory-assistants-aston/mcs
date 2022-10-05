package ru.aston.mcs.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.ResidentDTO;
import ru.aston.mcs.mapper.ResidentMapper;
import ru.aston.mcs.repository.ResidentRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ResidentServiceImplTest {
    @Mock
    private ResidentRepository residentRepository;

    @InjectMocks
    private ResidentServiceImpl residentService;
    @Mock
    ResidentMapper residentMapper;

    private ResidentDTO residentDTO;

    @BeforeEach
    void createDto() {
        residentDTO = new ResidentDTO();
        residentDTO.setUserId(null);
        residentDTO.setPhone("0");
        residentDTO.setAddress("0");
        residentDTO.setBalance(0.0);
        residentDTO.setNotifications(null);
        residentDTO.setResources(null);
    }

    @Test
    void getAllResidentTest() {
        residentService.getAllResident();
        Mockito.verify(residentRepository).findAll();
    }

    @Test
    void getResidentByIdTest() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> residentService.getResident(1L));
        Mockito.verify(residentRepository).findById(1L);
    }

    @Test
    void createResidentFromDtoTest() {
        residentService.createResident(residentDTO);
        Mockito.verify(residentRepository).save(residentMapper.toModel(residentDTO));
    }

    @Test
    void deleteResidentByIdTest() {
        residentService.deleteResident(1L);
        Mockito.verify(residentRepository).deleteById(1L);
    }
}