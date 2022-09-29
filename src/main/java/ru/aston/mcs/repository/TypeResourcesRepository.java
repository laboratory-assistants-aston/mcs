package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.TypeResources;

@Repository
public interface TypeResourcesRepository extends JpaRepository<TypeResources, Integer> {
}