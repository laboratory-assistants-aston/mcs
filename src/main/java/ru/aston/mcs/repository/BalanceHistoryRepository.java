package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.mcs.entity.BalanceHistory;

public interface BalanceHistoryRepository extends JpaRepository<BalanceHistory, Long> {
}