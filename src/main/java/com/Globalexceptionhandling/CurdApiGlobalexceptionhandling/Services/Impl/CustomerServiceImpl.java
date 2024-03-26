package com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Services.Impl;

import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.exceptions.CustomerAlreadyExistsException;
import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.exceptions.NoSuchCustomerExistsException;
import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Repository.CustomerRepository;
import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Services.CustomerService;
import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("NO CUSTOMER PRESENT WITH ID = " +id));
//        try {
//            return customerRepository.findById(id)
//                    .orElseThrow(() -> new NoSuchElementException("NO CUSTOMER PRESENT WITH ID = " + id));
//        } catch (NoSuchElementException e) {
//            System.err.println("NO CUSTOMER PRESENT WITH ID = " + id);
//            return null;
//        }

    }

    @Override
    public String addCustomer(Customer customer) {
        // Check if the customer ID is not null
//        if (customer.getId() != null) {
            //check customer already exist or not
            Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
            if (existingCustomer == null) {
                customerRepository.save(customer);
                return "Customer added successfully";
            } else
                throw new CustomerAlreadyExistsException("Customer already exists !!");
        }
//        else {
//            throw new IllegalArgumentException("Customer ID cannot be null");
//        }



    @Override
    public String updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (existingCustomer == null) {
            throw new NoSuchCustomerExistsException("No Such Customer exists !!");

        } else {
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            customerRepository.save(existingCustomer);
            return "Record update Successfully";
        }

    }
}
