package lk.mushtaqj.customer.services;

import lk.mushtaqj.customer.models.Customer;
import lk.mushtaqj.customer.repositories.CustomerRepository;
import lk.mushtaqj.customer.request.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository)
{
  public void registerCustomer (final CustomerRegistrationRequest request)
  {
    final var customer =
      Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();

    log.info("Customer {}", customer);

    customerRepository.save(customer);
  }
}
