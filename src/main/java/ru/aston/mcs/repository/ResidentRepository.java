package ru.aston.mcs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Resident;

@Repository
public
interface ResidentRepository extends JpaRepository<Resident, Long> {
}
