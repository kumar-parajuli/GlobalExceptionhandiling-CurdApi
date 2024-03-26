package com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Services;

import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.model.Customer;

public interface CustomerService {
    Customer getCustomer(Long id);

    String addCustomer(Customer customer);

    String updateCustomer(Customer customer);
}
