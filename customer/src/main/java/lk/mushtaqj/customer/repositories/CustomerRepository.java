package lk.mushtaqj.customer.repositories;

import lk.mushtaqj.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{ }
