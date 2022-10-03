package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.ResourceType;

@Repository
public interface ResourceTypeRepository extends JpaRepository<ResourceType, Long> {
}