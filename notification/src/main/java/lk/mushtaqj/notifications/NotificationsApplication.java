package lk.mushtaqj.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "lk.mushtaqj.clients")
public class NotificationsApplication
{

  public static void main (String[] args)
  {
    SpringApplication.run(NotificationsApplication.class, args);
  }
}
