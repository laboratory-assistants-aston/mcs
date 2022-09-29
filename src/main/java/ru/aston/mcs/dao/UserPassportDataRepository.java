package ru.aston.mcs.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.mcs.entity.UserPassportData;

public interface UserPassportDataRepository extends JpaRepository<UserPassportData, String> {

}
