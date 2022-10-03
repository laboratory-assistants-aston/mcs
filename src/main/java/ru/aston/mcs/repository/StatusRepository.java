package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
