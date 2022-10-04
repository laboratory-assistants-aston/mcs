package ru.aston.mcs.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.ResidentDTO;
import ru.aston.mcs.entity.Resident;
import ru.aston.mcs.mapper.ResidentMapper;
import ru.aston.mcs.repository.ResidentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        List<Resident> residentsActual = residentMapper.toModelList(Arrays.asList(residentDTO, residentDTO));
        Mockito.when(residentRepository.findAll()).thenReturn(residentsActual);
        List<ResidentDTO> allResidentExpected = residentService.getAllResident();
        Mockito.verify(residentRepository).findAll();
        assertEquals(allResidentExpected.size(), residentsActual.size() + 1);
    }

    @Test
    void getResidentByIdTest() {
        Resident resident = residentMapper.toModel(residentDTO);
        resident.setId(2L);
        Mockito.when(residentRepository.findById(2L)).thenReturn(Optional.of(resident));
        ResidentDTO residentActual = residentService.getResident(2L);
        Mockito.verify(residentRepository).findById(2L);
        assertEquals(resident.getId(), residentActual.getId());
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