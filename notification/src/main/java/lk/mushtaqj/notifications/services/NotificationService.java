package lk.mushtaqj.notifications.services;

import java.time.LocalDateTime;

import lk.mushtaqj.clients.notifications.requests.NotificationRequest;
import lk.mushtaqj.notifications.models.Notification;
import lk.mushtaqj.notifications.repositories.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record NotificationService(NotificationRepository notificationRepository)
{
  public void sendNotification (final NotificationRequest notificationRequest)
  {
    log.info("Sending Notification with Payload : {}", notificationRequest);

    //TODO :  Map to entity, create a mapper
    //TODO : Remove hardcoded values

    final Notification notification =
      Notification.builder().toCustomerEmail(notificationRequest.toCustomerEmail()).sentAt(LocalDateTime.now())
                  .sender("mjmushtaq@gmail.com").message(notificationRequest.message())
                  .sender("no-reply@fraudservice.com").build();

    notificationRepository.save(notification);
  }
}
