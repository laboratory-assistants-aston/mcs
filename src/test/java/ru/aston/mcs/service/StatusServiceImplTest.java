
package ru.aston.mcs.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.mapper.StatusMapper;
import ru.aston.mcs.repository.StatusRepository;
import ru.aston.mcs.service.impl.StatusServiceImpl;
import ru.aston.mcs.util.StatusDataUtils;
import java.util.List;
import java.util.Optional;


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

        //Arrange
        List<Status> entity = StatusDataUtils.createStatusEntityList();
        List<StatusDTO> dto = StatusDataUtils.createStatusDTOList();
        Mockito.when(statusRepository.findAll()).thenReturn(entity);
        Mockito.when(statusMapper.toDTOList(entity)).thenReturn(dto);

        //Action
        List<StatusDTO> fromDb = statusService.getAllStatus();

        //Assert
        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.size(), entity.size());

        Mockito.verify(statusRepository).findAll();
        Mockito.verify(statusMapper).toDTOList(entity);

    }

    @Test
    void getStatus() {

        //Arrange
        Status entity = StatusDataUtils.createStatusEntity();
        StatusDTO dto = StatusDataUtils.createStatusDTO();
        Mockito.when(statusRepository.findById(entity.getStatusId())).thenReturn(Optional.of(entity));
        Mockito.when(statusMapper.toDTO(entity)).thenReturn(dto);

        //Action
        StatusDTO fromDb = statusService.getStatus(entity.getStatusId());

        //Assert
        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.getStatusId(), entity.getStatusId());
        Assertions.assertEquals(fromDb.getName(), entity.getName());

        Mockito.verify(statusRepository).findById(entity.getStatusId());
        Mockito.verify(statusMapper).toDTO(entity);
    }

    @Test
    void addAndSaveStatus() {

        //Arrange
        Status entity = StatusDataUtils.createStatusEntity();
        StatusDTO dto = StatusDataUtils.createStatusDTO();
        Mockito.when(statusMapper.toModel(dto)).thenReturn(entity);
        Mockito.when(statusRepository.save(entity)).thenReturn(entity);

        //Action
        statusService.createStatus(dto);

        //Assert
        Mockito.verify(statusMapper).toModel(dto);
        Mockito.verify(statusRepository).save(entity);

    }

    @Test
    void deleteStatus() {

        //Arrange
        List<StatusDTO> dto = StatusDataUtils.createStatusDTOList();
        List<Status> entity = StatusDataUtils.createStatusEntityList();
        Mockito.when(statusRepository.findById(entity.get(0).getStatusId())).thenReturn(Optional.of(entity.get(0)));
        Mockito.doNothing().when(statusRepository).deleteById(entity.get(0).getStatusId());

        //Action
        statusService.deleteStatus(dto.get(0).getStatusId());

        //Assert
        Mockito.verify(statusRepository).findById(dto.get(0).getStatusId());
        Mockito.verify(statusRepository).deleteById(dto.get(0).getStatusId());

    }
}
