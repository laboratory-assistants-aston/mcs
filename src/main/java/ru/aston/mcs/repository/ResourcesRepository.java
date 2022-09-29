package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Resource;

@Repository
public interface ResourcesRepository extends JpaRepository<Resource, Long> {
}