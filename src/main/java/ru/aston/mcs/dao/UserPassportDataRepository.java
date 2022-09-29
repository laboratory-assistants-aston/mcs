package ru.aston.mcs.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.UserPassportData;


@Repository
public interface UserPassportDataRepository extends JpaRepository<UserPassportData, String> {
}
