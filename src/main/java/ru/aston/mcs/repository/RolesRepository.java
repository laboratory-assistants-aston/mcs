package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.mcs.entity.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
