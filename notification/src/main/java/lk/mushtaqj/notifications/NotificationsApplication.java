package lk.mushtaqj.notifications;

import lk.mushtaqj.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
  scanBasePackages = {
    "lk.mushtaqj.notifications",
    "lk.mushtaqj.amqp"
  }
)
@EnableEurekaClient
@EnableFeignClients(basePackages = "lk.mushtaqj.clients")
public class NotificationsApplication
{

  public static void main (String[] args)
  {
    SpringApplication.run(NotificationsApplication.class, args);
  }
//
//  @Bean
//  CommandLineRunner commandLineRunner(final RabbitMQMessageProducer producer,
//                                      final NotificationConfig notificationConfig) {
//    return args -> {
//      producer.publish("foo",notificationConfig.getExchangeName(), notificationConfig.getInternalNotificationRoutingKey());
//    };
//  }
}
