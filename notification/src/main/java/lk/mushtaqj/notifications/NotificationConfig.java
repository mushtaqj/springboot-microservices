package lk.mushtaqj.notifications;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

  @Bean
  public TopicExchange topicExchange(){
    return new TopicExchange(this.exchangeName);
  }

  @Bean
  public Queue notificationQueue(){
    return new Queue(this.notificationQueueName);
  }

  @Bean
  public Binding exchangeToQueueBinding(final TopicExchange topicExchange,
                                        final Queue notificationQueue){

    return BindingBuilder.bind(notificationQueue)
                         .to(topicExchange)
                         .with(this.internalNotificationRoutingKey);
  }

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
