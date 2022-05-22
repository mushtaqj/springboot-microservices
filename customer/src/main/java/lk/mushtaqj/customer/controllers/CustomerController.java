package lk.mushtaqj.customer.controllers;

import lk.mushtaqj.customer.request.CustomerRegistrationRequest;
import lk.mushtaqj.customer.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public record CustomerController(CustomerService customerService)
{

  @PostMapping
  public void registerCustomer (final @RequestBody CustomerRegistrationRequest customerRegistration)
  {
    log.info("new customer registration {}", customerRegistration);
    customerService.registerCustomer(customerRegistration);
  }

}
