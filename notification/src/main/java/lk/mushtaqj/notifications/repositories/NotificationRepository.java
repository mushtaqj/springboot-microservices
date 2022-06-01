package lk.mushtaqj.notifications.repositories;

import lk.mushtaqj.notifications.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long>
{ }
