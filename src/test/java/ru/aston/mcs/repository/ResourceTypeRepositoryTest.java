package ru.aston.mcs.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.util.ResourceTypeDataUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest
public class ResourceTypeRepositoryTest {

    @Autowired
    private ResourceTypeRepository resourceTypeRepository;

    @AfterEach
    public void tearDown() {
        resourceTypeRepository.deleteAll();
    }

    @Test
    public void testAddResourceType() {

        //Arrange
        ResourceType entity = ResourceTypeDataUtils.createResourceTypeEntity();

        //Action
        resourceTypeRepository.save(entity);

        //Assert
        Optional<ResourceType> fromDb = resourceTypeRepository.findById(entity.getNameId());
        Assertions.assertNotNull(fromDb.get());
    }

    @Test
    public void testGetStatus() {

        //Arrange
        ResourceType entity = ResourceTypeDataUtils.createResourceTypeEntity();
        resourceTypeRepository.save(entity);

        //Action
        Optional<ResourceType> statusFromDb = resourceTypeRepository.findById(entity.getNameId());

        //Assert
        Assertions.assertEquals(statusFromDb.get().getNameId(), entity.getNameId());
        Assertions.assertEquals(statusFromDb.get().getName(), entity.getName());
        Assertions.assertEquals(statusFromDb.get().getCost(), entity.getCost());
    }


    @Test
    public void testGetAllStatus() {

        //Arrange
        List<ResourceType> entities = ResourceTypeDataUtils.createResourceTypeEntityList();
        List<ResourceType> newStatusListToDb =
                entities.stream()
                        .peek(status -> resourceTypeRepository.save(status))
                        .collect(Collectors.toList());

        //Action
        List<ResourceType> fromDb = resourceTypeRepository.findAll();

        //Assert
        Assertions.assertEquals(fromDb.size(), newStatusListToDb.size());

    }

    @Test
    public void testDeleteStatus() {

        //Arrange
        List<ResourceType> entities = ResourceTypeDataUtils.createResourceTypeEntityList();
        List<ResourceType> toDb = entities.stream()
                .peek(status -> resourceTypeRepository.save(status))
                .collect(Collectors.toList());

        //Action
        resourceTypeRepository.deleteById(1L);
        List<ResourceType> fromDb = resourceTypeRepository.findAll();

        //Assert
        Assertions.assertEquals(fromDb.size(), toDb.size()-1);
    }

}
