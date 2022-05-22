package lk.mushtaqj.fraud.respositories;

import lk.mushtaqj.fraud.models.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Long>
{ }
