package lk.mushtaqj.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
  scanBasePackages = {
    "lk.mushtaqj.customer",
    "lk.mushtaqj.amqp"
  }
)
@EnableEurekaClient
@EnableFeignClients(basePackages = { "lk.mushtaqj.clients" })
public class CustomerApplication
{
  public static void main (String[] args)
  {
    SpringApplication.run(CustomerApplication.class, args);
  }
}
