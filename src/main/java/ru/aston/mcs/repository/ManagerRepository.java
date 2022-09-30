package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
