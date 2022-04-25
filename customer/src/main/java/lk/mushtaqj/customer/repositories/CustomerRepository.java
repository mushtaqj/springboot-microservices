package lk.mushtaqj.customer.repositories;

import lk.mushtaqj.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{ }
