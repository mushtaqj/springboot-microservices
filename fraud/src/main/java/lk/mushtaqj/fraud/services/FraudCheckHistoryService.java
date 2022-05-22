package lk.mushtaqj.fraud.services;

import java.time.LocalDateTime;

import lk.mushtaqj.fraud.models.FraudCheckHistory;
import lk.mushtaqj.fraud.respositories.FraudCheckHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository)
{

  public boolean isFraudulentCustomer (final Long customerId)
  {
    log.info("Fraud Check for customerId : {}", customerId);
    final boolean isFraudster = false;
    final FraudCheckHistory checkHistory = FraudCheckHistory.builder()
                                                            .customerId(customerId)
                                                            .createdAt(LocalDateTime.now())
                                                            .isFraudster(isFraudster)
                                                            .build();

    fraudCheckHistoryRepository.save(checkHistory);

    return isFraudster;
  }
}
