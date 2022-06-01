package lk.mushtaqj.clients.notifications;

import lk.mushtaqj.clients.UrlPaths;
import lk.mushtaqj.clients.notifications.requests.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
  name = "notification",
  path = UrlPaths.Notifications.basePath
)
public interface NotificationClient
{
  @PostMapping
  void sendNotification (@RequestBody final NotificationRequest notificationRequest);
}
