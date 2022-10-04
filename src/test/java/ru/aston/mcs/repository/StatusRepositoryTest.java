package ru.aston.mcs.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.util.StatusDataUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




@DataJpaTest
public class StatusRepositoryTest {

    @Autowired
    private StatusRepository statusRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    public void tearDown() {
        statusRepository.deleteAll();
    }

    @Test
    public void testAddStatus() {

        //Arrange
        Status newStatusEntity = StatusDataUtils.createStatusEntity();

        //Action
        statusRepository.save(newStatusEntity);

        //Assert
        Optional<Status> statusFromDb = statusRepository.findById(newStatusEntity.getStatusId());
        Assertions.assertNotNull(statusFromDb.get());
    }

    @Test
    public void testGetStatus() {

        //Arrange
        Status newStatusEntity = StatusDataUtils.createStatusEntity();
        statusRepository.save(newStatusEntity);

        //Action
        Optional<Status> statusFromDb = statusRepository.findById(newStatusEntity.getStatusId());

        //Assert
       org.junit.jupiter.api.Assertions.assertEquals(statusFromDb.get().getStatusId(), newStatusEntity.getStatusId());
        Assertions.assertEquals(statusFromDb.get().getStatusName(), newStatusEntity.getStatusName());
    }


    @Test
    public void testGetAllStatus() {

        //Arrange
        List<Status> newStatusList = StatusDataUtils.createStatusEntityList();
        List<Status> newStatusListToDb =
                newStatusList.stream()
                        .peek(status -> statusRepository.save(status))
                        .collect(Collectors.toList());

        //Action
        List<Status> fromDb = statusRepository.findAll();

        //Assert
        Assertions.assertEquals(fromDb.size(), newStatusListToDb.size());

    }

    @Test
    public void tesDeleteStatus() {

        //Arrange
        List<Status> newStatusList = StatusDataUtils.createStatusEntityList();
        List<Status> toDb = newStatusList.stream()
                .peek(status -> statusRepository.save(status))
                .collect(Collectors.toList());

        //Action
        statusRepository.deleteById(1L);
        List<Status> fromDb = statusRepository.findAll();

        //Assert
        Assertions.assertEquals(fromDb.size(), toDb.size()-1);
    }
}
