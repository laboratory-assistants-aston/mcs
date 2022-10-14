package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.ResourceType;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    //получить список всех ресурсов resource_identifier, resource_type_name по определенному типу
    List<Resource> findAllResourceByResourceType(ResourceType resourceType);
}
