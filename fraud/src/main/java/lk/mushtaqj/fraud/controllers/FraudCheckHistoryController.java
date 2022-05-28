package lk.mushtaqj.fraud.controllers;

import lk.mushtaqj.customer.response.FraudCheckResponse;
import lk.mushtaqj.fraud.services.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckHistoryController
{
  private final FraudCheckHistoryService fraudCheckHistoryService;

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") final Long customerId) {

    final boolean fraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);

    return new FraudCheckResponse(fraudulentCustomer);
  }
}
