package ru.aston.mcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
