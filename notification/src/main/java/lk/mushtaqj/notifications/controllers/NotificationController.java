package lk.mushtaqj.notifications.controllers;

import lk.mushtaqj.clients.notifications.requests.NotificationRequest;
import lk.mushtaqj.notifications.services.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/notifications")
@RestController
public record NotificationController(NotificationService notificationService)
{

  @PostMapping
  public void sendNotification (@RequestBody final NotificationRequest notificationRequest)
  {
    notificationService.sendNotification(notificationRequest);
  }

}
