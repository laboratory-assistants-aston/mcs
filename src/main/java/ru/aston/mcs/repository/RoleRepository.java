package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}