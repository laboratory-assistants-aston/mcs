package ru.aston.mcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Housekeeper;

@Repository
public interface HousekeeperRepository extends JpaRepository<Housekeeper, Integer> {
}
