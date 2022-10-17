
package ru.aston.mcs.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.entity.enums.StatusName;
import ru.aston.mcs.mapper.StatusMapper;
import ru.aston.mcs.repository.StatusRepository;
import ru.aston.mcs.service.impl.StatusServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StatusServiceImplTest {

    @Mock
    StatusRepository statusRepository;

    @Mock
    StatusMapper statusMapper;

    @InjectMocks
    StatusServiceImpl statusService;

    @Test
    void getAllStatus() {

        List<StatusDTO> dto = new ArrayList<>();
        dto.add(new StatusDTO(1L, StatusName.BOOKING));
        dto.add(new StatusDTO(2L, StatusName.READY_TO_USE));

        List<Status> entity = new ArrayList<>();
        entity.add(new Status(1L, StatusName.BOOKING));
        entity.add(new Status(2L, StatusName.READY_TO_USE));

        Mockito.when(statusRepository.findAll()).thenReturn(entity);
        Mockito.when(statusMapper.toDTOList(entity)).thenReturn(dto);

        List<StatusDTO> fromDb = statusService.getAllStatus();

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.size(), entity.size());

        Mockito.verify(statusRepository).findAll();
        Mockito.verify(statusMapper).toDTOList(entity);

    }

    @Test
    void getStatus() {

        Status entity = new Status(1L, StatusName.BOOKING);
        StatusDTO dtoFromDb = new StatusDTO(1L, StatusName.BOOKING);

        Mockito.when(statusRepository.findById(entity.getStatusId())).thenReturn(Optional.of(entity));
        Mockito.when(statusMapper.toDTO(entity)).thenReturn(dtoFromDb);

        StatusDTO fromDb = statusService.getStatus(entity.getStatusId());

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.getStatusId(), entity.getStatusId());
        Assertions.assertEquals(fromDb.getStatusName(), entity.getStatus());

        Mockito.verify(statusRepository).findById(entity.getStatusId());
        Mockito.verify(statusMapper).toDTO(entity);
    }

    @Test
    void createStatus() {

        StatusDTO dtoToDb = new StatusDTO(null, StatusName.BOOKING);
        Status entity = new Status(1l, StatusName.BOOKING);
        StatusDTO dtoFromDb = new StatusDTO(1l, StatusName.BOOKING);
        Mockito.when(statusRepository.save(statusMapper.toModel(dtoToDb))).thenReturn(entity);
        Mockito.when(statusMapper.toDTO(entity)).thenReturn(dtoFromDb);

        statusService.createStatus(dtoToDb);

        Mockito.verify(statusRepository).save(statusMapper.toModel(dtoToDb));

    }

    @Test
    void updateStatus() {

        StatusDTO dto = new StatusDTO(null, StatusName.READY_TO_USE);
        Status changeEntity = new Status(1L, StatusName.BOOKING);
        Status updatedEntity = new Status(1L,  StatusName.READY_TO_USE);

        Mockito.when(statusRepository.findById(changeEntity.getStatusId())).thenReturn(Optional.of(changeEntity));
        Mockito.when(statusRepository.save(updatedEntity)).thenReturn(updatedEntity);

        statusService.updateStatus(changeEntity.getStatusId(), dto);

        Mockito.verify(statusRepository).findById(changeEntity.getStatusId());
        Mockito.verify(statusRepository).save(changeEntity);
    }

    @Test
    void deleteStatus() {

        statusService.deleteStatus(1L);
        Mockito.verify(statusRepository).deleteById(1L);

    }
}
