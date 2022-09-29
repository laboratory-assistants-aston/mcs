package ru.aston.mcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
