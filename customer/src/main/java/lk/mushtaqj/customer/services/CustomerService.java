package lk.mushtaqj.customer.services;

import java.util.Optional;

import lk.mushtaqj.customer.models.Customer;
import lk.mushtaqj.customer.repositories.CustomerRepository;
import lk.mushtaqj.customer.request.CustomerRegistrationRequest;
import lk.mushtaqj.customer.response.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate)
{
  public void registerCustomer (final CustomerRegistrationRequest request)
  {
    final var customer =
      Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();

    log.info("Customer {}", customer);
    customerRepository.saveAndFlush(customer);

    final Optional<FraudCheckResponse> fraudCheckResponse = Optional.ofNullable(restTemplate.getForObject(
      "http://FRAUD/api/v1/fraud-check/{customerId}",
      FraudCheckResponse.class,
      customer.getId()));

    if (fraudCheckResponse.isPresent())
    {
      if (fraudCheckResponse.get().isFraudulentCustomer())
      {
        throw new IllegalStateException("Customer is a fraudster");
      }
    }
  }
}
