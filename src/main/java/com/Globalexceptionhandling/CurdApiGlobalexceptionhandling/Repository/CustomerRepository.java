package com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Repository;

import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
