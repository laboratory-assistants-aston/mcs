package ru.aston.mcs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.ResidentPassport;


@Repository
public interface ResidentPassportRepository extends JpaRepository<ResidentPassport, String> {

}
