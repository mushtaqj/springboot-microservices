package lk.mushtaqj.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQMessageProducer
{

  private final AmqpTemplate amqpTemplate;

  public RabbitMQMessageProducer (final AmqpTemplate amqpTemplate) { this.amqpTemplate = amqpTemplate; }

  public void publish (Object payload, String exchangeName, String routingKey)
  {
    log.info("Publishing to {} using routingKey {}. Payload {}", exchangeName, routingKey, payload);
    amqpTemplate.convertAndSend(exchangeName, routingKey, payload);
    log.info("Published to {} using routingKey {}. Payload {}", exchangeName, routingKey, payload);
  }
}
