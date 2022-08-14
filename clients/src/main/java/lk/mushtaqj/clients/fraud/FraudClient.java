package lk.mushtaqj.clients.fraud;

import lk.mushtaqj.clients.UrlPaths;
import lk.mushtaqj.clients.fraud.response.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
  value = "fraud",
  path = UrlPaths.FraudCheck.basePath
)
public interface FraudClient
{
  @GetMapping(path = "{customerId}")
  FraudCheckResponse isFraudster(@PathVariable("customerId") final Long customerId);
}
