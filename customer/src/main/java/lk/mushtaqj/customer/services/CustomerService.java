package lk.mushtaqj.customer.services;

import lk.mushtaqj.amqp.RabbitMQMessageProducer;
import lk.mushtaqj.clients.fraud.FraudClient;
import lk.mushtaqj.clients.notifications.requests.NotificationRequest;
import lk.mushtaqj.customer.models.Customer;
import lk.mushtaqj.customer.repositories.CustomerRepository;
import lk.mushtaqj.customer.request.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient,
                              RabbitMQMessageProducer rabbitMQMessageProducer)
{
  public void registerCustomer (final CustomerRegistrationRequest request)
  {
    final var customer =
      Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();

    log.info("Customer {}", customer);
    customerRepository.saveAndFlush(customer);

    final boolean fraudulentCustomer = fraudClient.isFraudster(customer.getId()).isFraudulentCustomer();

    if (fraudulentCustomer)
    {
      throw new IllegalStateException("Customer is a fraudster");
    }

    final NotificationRequest notificationRequest =
      new NotificationRequest(customer.getId(), customer.getEmail(), "Customer created successfully");

    rabbitMQMessageProducer.publish(notificationRequest,
                                    "internal.exchange",
                                    "internal.notification.routing-key");
  }
}
