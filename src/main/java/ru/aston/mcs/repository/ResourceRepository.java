package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.mcs.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
