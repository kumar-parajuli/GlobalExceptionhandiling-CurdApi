package com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Controller;

import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.exceptions.CustomerAlreadyExistsException;
import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Services.CustomerService;
import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.model.Customer;
import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //Get Customer by id
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return  customerService.getCustomer(id);
    }
    //Add new Customer
    @PostMapping("/addCustomer")
    public String addcustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    // Update Customer details
    @PutMapping("/updateCustomer")
    public String
    updateCustomer(@RequestBody Customer customer)
    {
        return customerService.updateCustomer(customer);
    }
    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse
    handleCustomerAlreadyExistsException(
            CustomerAlreadyExistsException ex)
    {
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                ex.getMessage());
    }
}
