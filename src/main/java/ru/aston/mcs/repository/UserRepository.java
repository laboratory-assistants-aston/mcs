package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
