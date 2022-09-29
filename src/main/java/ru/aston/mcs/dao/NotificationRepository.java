package ru.aston.mcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.mcs.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
