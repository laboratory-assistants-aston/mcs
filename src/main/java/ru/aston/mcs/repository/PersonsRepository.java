package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.mcs.entity.Person;

public interface PersonsRepository extends JpaRepository<Person, Long> {
}
