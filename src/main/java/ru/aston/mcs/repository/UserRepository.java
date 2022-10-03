package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.mcs.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
