package lk.mushtaqj.notifications;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig
{
  @Value("${rabbitmq.exchanges.internal}")
  private String exchangeName;

  @Value("${rabbitmq.queue.notification}")
  private String notificationQueueName;

  @Value("${rabbitmq.routing-keys.internal-notification}")
  private String internalNotificationRoutingKey;

  public String getExchangeName ()
  {
    return exchangeName;
  }

  public String getNotificationQueueName ()
  {
    return notificationQueueName;
  }

  public String getInternalNotificationRoutingKey ()
  {
    return internalNotificationRoutingKey;
  }
}
