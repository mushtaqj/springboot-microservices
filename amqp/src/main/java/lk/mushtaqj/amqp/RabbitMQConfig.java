package lk.mushtaqj.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
  private final ConnectionFactory connectionFactory;

  public RabbitMQConfig (ConnectionFactory connectionFactory) { this.connectionFactory = connectionFactory; }

  @Bean
  public MessageConverter jacksonConverter() {
    final MessageConverter jacksonConverter = new Jackson2JsonMessageConverter();
    return jacksonConverter;
  }

  @Bean
  public AmqpTemplate amqpTemplate(final MessageConverter jacksonConverter) {
    // Connection factory will provide configurable properties to the receiver
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

    // The message would be sent as a json instead of plain text
    rabbitTemplate.setMessageConverter(jacksonConverter);

    return rabbitTemplate;
  }

  /**
   * Allows to receive messages from the queue.
   * @param jacksonConverter {@link MessageConverter}
   * @return SimpleRabbitListenerContainerFactory
   */
  @Bean
  public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(final MessageConverter jacksonConverter){
    final SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory =
      new SimpleRabbitListenerContainerFactory();

    // Connection factory will provide configurable properties to the receiver
    simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
    // The message would be received as a json instead of plain text
    simpleRabbitListenerContainerFactory.setMessageConverter(jacksonConverter);

    return simpleRabbitListenerContainerFactory;
  }

}
