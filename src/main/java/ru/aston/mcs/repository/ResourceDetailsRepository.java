package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.ResourceDetails;

@Repository
public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails, Integer> {
}